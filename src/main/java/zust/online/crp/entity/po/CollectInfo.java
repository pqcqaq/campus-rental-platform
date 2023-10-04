package zust.online.crp.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author qcqcqc
 */
@TableName("collect")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CollectInfo {
    private Long id;
    private Long postId;
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Long createBy;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
}
