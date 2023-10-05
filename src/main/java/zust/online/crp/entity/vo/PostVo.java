package zust.online.crp.entity.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zust.online.crp.annotation.SensitiveWords;
import zust.online.crp.entity.po.Post;
import zust.online.crp.entity.po.User;
import zust.online.crp.serializer.SensitiveStringReplaceDeserializer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author qcqcqc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostVo {
    private String id;
    @NotBlank(message = "标题不能为空")
    @Size(max = 20, message = "标题长度不能超过20")
    @SensitiveWords(message = "标题含有敏感词")
    private String title;
    @NotBlank(message = "内容不能为空")
    @JsonDeserialize(using = SensitiveStringReplaceDeserializer.class)
    private String intro;
    @NotEmpty(message = "至少一张图片")
    private List<Image> imgs;
    private String createTime;
    private String updateTime;
    private User author;
    private Long likeNum;
    private Long commentNum;
    private Long collectNum;
    private List<CommentVo> comments;
    private Boolean isLike;
    private Boolean isCollect;
    private Integer shareNum;
    private Integer viewNum;
    private Integer status;
    private Boolean editable;

    public Post toSavePo() {
        Post post = new Post();
        post.setTitle(this.title);
        post.setIntro(this.intro);
        post.setImgs(this.imgs.stream().map((item) -> Long.parseLong(item.getId())).toList());
        return post;
    }
}
