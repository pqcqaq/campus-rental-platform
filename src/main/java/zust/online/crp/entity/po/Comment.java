package zust.online.crp.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zust.online.crp.entity.vo.CommentVo;
import zust.online.crp.entity.vo.UserVo;
import zust.online.crp.utils.TimeFormatterUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author qcqcqc
 */
@TableName(value = "comment", autoResultMap = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    private Long id;
    private Long postId;
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Long createBy;
    private String commentDetail;
    @TableField(value = "comment_ids", typeHandler = JacksonTypeHandler.class)
    private List<Long> commentsIds;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    public CommentVo toVo(UserVo author, List<CommentVo> commentVos) {
        return CommentVo.builder()
                .id(String.valueOf(this.id))
                .detail(this.commentDetail)
                .author(author)
                .createTime(TimeFormatterUtils.dateToString(this.createTime))
                .comments(commentVos)
                .build();
    }
}
