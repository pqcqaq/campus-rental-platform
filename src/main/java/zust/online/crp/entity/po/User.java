package zust.online.crp.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author qcqcqc
 */
@TableName(value = "user_info", autoResultMap = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 8307780751321906609L;
    private Long id;
    private String linkMan;
    private String username;
    private String password;
    private String mobile;
    private String nickName;
    private String school;
    @TableField(value = "roles", typeHandler = JacksonTypeHandler.class)
    private List<String> roles;
}
