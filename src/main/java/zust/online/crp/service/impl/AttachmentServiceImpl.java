package zust.online.crp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import zust.online.crp.entity.UserLogin;
import zust.online.crp.entity.po.Attachment;
import zust.online.crp.entity.po.User;
import zust.online.crp.exception.ErrorFoundUserException;
import zust.online.crp.exception.ErrorSaveFileException;
import zust.online.crp.mapper.AttachmentMapper;
import zust.online.crp.service.AttachmentService;
import zust.online.crp.utils.ContextUtil;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author qcqcqc
 */
@Service
@Slf4j
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment> implements AttachmentService {

    @Value("${avatarPath}")
    private String avatarPath;

    @Override
    public Long saveImgFile(MultipartFile avatar) {
        // 从上下文取出token
        String originalFilename = avatar.getOriginalFilename();
        log.info("上传文件：{}", originalFilename);
        //生成随机的uuid
        String uuid = UUID.randomUUID().toString();
        //获取文件后缀名
        String suffix = null;
        try {
            if (originalFilename != null) {
                suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            }
        } catch (Exception e) {
            log.error("上传失败", e);
            throw new ErrorSaveFileException("上传失败");
        }
        //生成新的文件名
        String fileName = System.currentTimeMillis() + "-" + uuid + suffix;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        // 新建目录，以当前日期为目录名
        String datePath = avatarPath + formatter.format(date) + "/";

        File file = new File(datePath);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (!mkdirs) {
                log.error("创建目录失败");
                throw new ErrorSaveFileException("上传失败");
            }
        }

        String localPath = datePath + fileName;
        try {
            avatar.transferTo(new File(localPath));
        } catch (IOException e) {
            log.error("上传失败", e);
            throw new ErrorSaveFileException("上传失败");
        }
        Attachment attachment = new Attachment();
        attachment.setOriginalFilename(originalFilename);
        attachment.setServerPath(localPath);
        // 计算md5
        String md5 = computeMd5(localPath);
        // 查询是否已经存在
        Attachment one = this.getOne(new LambdaQueryWrapper<Attachment>().eq(Attachment::getMd5, md5));
        if (one != null) {
            log.info("文件已存在，不再重复保存: {}", one);
            try {
                Files.deleteIfExists(Paths.get(localPath));
            } catch (IOException e) {
                log.error("删除文件失败", e);
            }
            return one.getId();
        }
        attachment.setMd5(md5);
        User currentUser = ContextUtil.getCurrentUser();
        if (currentUser != null) {
            attachment.setCreateBy(currentUser.getId());
        } else {
            throw new ErrorFoundUserException("用户未登录");
        }
        this.save(attachment);
        return attachment.getId();
    }

    private String computeMd5(String filePath) {
        String md5 = null;
        try (FileInputStream inputStream = new FileInputStream(ResourceUtils.getFile(filePath))) {
            md5 = DigestUtils.md5DigestAsHex(inputStream);
        } catch (Exception e) {
            log.error("get {} md5 error, {}", filePath, e.getMessage());
        }
        return md5;
    }
}
