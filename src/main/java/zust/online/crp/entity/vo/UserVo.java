package zust.online.crp.entity.vo;

import com.hanzoy.utils.Token;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zust.online.crp.entity.po.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author qcqcqc
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private String linkMan;
    private String username;
    private String avatar;
    private String mobile;
    @NotBlank(message = "昵称不为空")
    @Size(min = 1, max = 30, message = "昵称长度为1-30")
    private String nickName;
    private String school;
    private String token;

    public User toPo() {
        return User.builder()
                .linkMan(linkMan)
                .username(username)
                .avatar(avatar)
                .mobile(mobile)
                .nickName(nickName)
                .school(school)
                .build();
    }
}
