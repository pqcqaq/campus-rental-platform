package zust.online.crp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.enums.ResultCode;
import zust.online.crp.entity.po.Attachment;
import zust.online.crp.entity.po.User;
import zust.online.crp.entity.vo.PostVo;
import zust.online.crp.entity.vo.SwiperItemVo;
import zust.online.crp.service.AttachmentService;
import zust.online.crp.service.PostService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qcqcqc
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Resource
    private AttachmentService attachmentService;
    @Resource
    private PostService postService;

    @PostMapping("/init")
    public Result<String> init() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof User user)) {
            log.info("获取上下文：{}", principal);
            return Result.error(ResultCode.GO_TO_LOGIN, "用户未登录");
        }
        log.info("用户：{}，初始化成功", user.getUsername());
        return Result.success("初始化成功");
    }

    @GetMapping("/test")
    public Result<String> test() {
        return Result.success("测试成功");
    }

    /**
     * 上传头像
     *
     * @param avatar 头像文件
     * @return 结果
     */
    @PostMapping(value = "/avatar", headers = "content-type=multipart/form-data")
    public Result<String> upload(MultipartFile avatar) {
        try {
            Long l = attachmentService.saveImgFile(avatar);
            return Result.success("上传成功", String.valueOf(l));
        } catch (Exception e) {
            log.error("上传失败", e);
            return Result.error(500, "上传失败", null);
        }
    }

    /**
     * 获取头像
     *
     * @param id       头像id
     * @param response 响应
     *                 通过id获取头像
     */
    @GetMapping("/img/{id}")
    public void getAvatar(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Attachment byId = attachmentService.getById(id);
        if (byId == null) {
            response.setStatus(404);
            Result<String> error = Result.error(404, "img not found");
            new ObjectMapper().writeValue(response.getOutputStream(), error);
            return;
        }
        String serverPath = byId.getServerPath();
        log.info("获取图片：{}", serverPath);
        // 将图片写出到浏览器
        try {
            response.setContentType("image/jpeg");
            response.getOutputStream().write(Files.readAllBytes(Paths.get(serverPath)));
        } catch (IOException e) {
            log.error("获取图片失败", e);
            response.setStatus(500);
        }
    }

    @GetMapping("/swiper")
    public Result<List<SwiperItemVo>> getSwiper() {
        ArrayList<SwiperItemVo> swiperItemVos = new ArrayList<>();
        List<PostVo> postVos = postService.getTopHotPostVos(6);
        for (PostVo postVo : postVos) {
            SwiperItemVo swiperItemVo = new SwiperItemVo();
            swiperItemVo.setImg(String.valueOf(postVo.getImgs().get(0).getId()));
            swiperItemVo.setText(postVo.getTitle());
            swiperItemVo.setPostId(String.valueOf(postVo.getId()));
            swiperItemVos.add(swiperItemVo);
        }

        return Result.success("获取成功", swiperItemVos);
    }
}
