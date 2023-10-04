package zust.online.crp.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qcqcqc
 */
@TableName("comment")
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
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private String createTime;
}
