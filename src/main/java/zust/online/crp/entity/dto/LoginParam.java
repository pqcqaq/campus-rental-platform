package zust.online.crp.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String username;
    private String password;
}
