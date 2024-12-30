package zust.online.crp.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author qcqcqc
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 4404898457720364020L;
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
