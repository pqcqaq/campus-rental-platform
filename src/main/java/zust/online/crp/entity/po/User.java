package zust.online.crp.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.hanzoy.utils.Token;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zust.online.crp.entity.vo.UserVo;

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
    private String avatar;
    private String password;
    private String mobile;
    private String nickName;
    private String school;
    @TableField(value = "roles", typeHandler = JacksonTypeHandler.class)
    private List<String> roles;

    public UserVo toVo(String token) {
        return UserVo.builder()
                .linkMan(linkMan)
                .username(username)
                .avatar(avatar)
                .mobile(mobile)
                .nickName(nickName)
                .school(school)
                .token(token)
                .build();
    }
}
