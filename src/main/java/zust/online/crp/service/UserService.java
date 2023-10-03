package zust.online.crp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.dto.LoginParam;
import zust.online.crp.entity.po.User;
import zust.online.crp.entity.vo.UserVo;

/**
 * @author qcqcqc
 */
public interface UserService extends IService<User> {
    /**
     * 登录
     *
     * @param loginParam 登录参数
     * @return token
     */
    Result<UserVo> login(LoginParam loginParam);

    UserVo alter(UserVo userVo);

    String saveAlterAvatar(String avatar);
}
