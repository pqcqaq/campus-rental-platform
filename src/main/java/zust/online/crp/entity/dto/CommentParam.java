package zust.online.crp.entity.dto;

import lombok.Data;
import zust.online.crp.annotation.SensitiveWords;

import javax.validation.constraints.NotBlank;

/**
 * @author qcqcqc
 */
@Data
public class CommentParam {
    @NotBlank(message = "postId不能为空")
    private String postId;
    private String parentId;
    @NotBlank(message = "评论内容不能为空")
    @SensitiveWords(message = "评论内容中含有敏感词")
    private String commentDetail;
}
