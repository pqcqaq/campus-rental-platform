package zust.online.crp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;
import zust.online.crp.entity.po.Attachment;

/**
 * @author qcqcqc
 */
public interface AttachmentService extends IService<Attachment> {

    /**
     * 保存头像
     *
     * @param avatar 头像文件
     * @return 附件id
     */
    Long saveImgFile(MultipartFile avatar);
}
