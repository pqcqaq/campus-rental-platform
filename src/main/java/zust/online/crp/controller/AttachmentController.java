package zust.online.crp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import zust.online.crp.entity.Result;
import zust.online.crp.service.AttachmentService;

import javax.annotation.Resource;

/**
 * @author qcqcqc
 */
@RestController
@RequestMapping("/attachment")
@Slf4j
public class AttachmentController {
    @Resource
    private AttachmentService attachmentService;

    /**
     * 上传图片
     *
     * @param img   图片文件
     * @return 结果
     */
    @PostMapping(value = "/img", headers = "content-type=multipart/form-data")
    public Result<String> upload(MultipartFile img) {
        try {
            Long l = attachmentService.saveImgFile(img);
            return Result.success("上传成功", String.valueOf(l));
        } catch (Exception e) {
            log.error("上传失败", e);
            return Result.error(500, "上传失败", null);
        }
    }
}
