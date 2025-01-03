package zust.online.crp.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zust.online.crp.entity.vo.CommentVo;
import zust.online.crp.entity.vo.Image;
import zust.online.crp.entity.vo.PostVo;
import zust.online.crp.entity.vo.UserVo;
import zust.online.crp.utils.TimeFormatterUtils;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author qcqcqc
 */
@TableName(value = "post_details", autoResultMap = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = 6274707176921446794L;
    @TableId
    private Long id;
    private String title;
    private String intro;
    @TableField(value = "imgs", typeHandler = JacksonTypeHandler.class)
    private List<Long> imgs;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    private Boolean rented;
    @TableLogic(value = "0", delval = "1")
    private Boolean isDeleted;


    public PostVo toVo(List<Image> imgs,
                       List<CommentVo> commentVos,
                       UserVo author,
                       Long likeNum,
                       Long commentNum,
                       Long collectNum,
                       Boolean isLike,
                       Boolean isCollect,
                       Integer shareNum,
                       Integer viewNum,
                       Integer status,
                       Boolean editable

    ) {
        return PostVo.builder()
                .id(String.valueOf(this.id))
                .title(this.title)
                .intro(this.intro)
                .imgs(imgs)
                .createTime(TimeFormatterUtils.dateToString(this.createTime))
                .updateTime(TimeFormatterUtils.dateToString(this.updateTime))
                .author(author)
                .likeNum(likeNum)
                .commentNum(commentNum)
                .comments(commentVos)
                .collectNum(collectNum)
                .isLike(isLike)
                .isCollect(isCollect)
                .shareNum(shareNum)
                .viewNum(viewNum)
                .status(status)
                .editable(editable)
                .build();
    }
}
