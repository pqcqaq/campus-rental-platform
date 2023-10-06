package zust.online.crp.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author qcqcqc
 */
@TableName("attachment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attachment {
    private Long id;
    private String originalFilename;
    private String serverPath;
    private String md5;
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Long createBy;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
