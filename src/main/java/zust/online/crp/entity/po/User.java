package zust.online.crp.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zust.online.crp.entity.vo.UserVo;
import zust.online.crp.serializer.LocalDateTimeSerializer;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    private String background;
    private String password;
    private String mobile;
    private String nickName;
    private String school;
    @TableField(value = "roles", typeHandler = JacksonTypeHandler.class)
    private List<String> roles;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;
    private Boolean disabled;

    public UserVo toVo(String token, Long subscribedNum, Long beSubscribeNum, Boolean isFollow) {
        return UserVo.builder()
                .id(id)
                .linkMan(linkMan)
                .username(username)
                .avatar(avatar)
                .background(background)
                .mobile(mobile)
                .nickName(nickName)
                .school(school)
                .token(token)
                .role(roles.get(0))
                .followNum(subscribedNum)
                .fansNum(beSubscribeNum)
                .isFollow(isFollow)
                .build();
    }

    public boolean isAdmin() {
        return roles.contains("ROLE_ADMIN");
    }
}
