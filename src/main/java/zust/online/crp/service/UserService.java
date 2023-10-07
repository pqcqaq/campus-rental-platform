package zust.online.crp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.dto.LoginParam;
import zust.online.crp.entity.po.User;
import zust.online.crp.entity.vo.UserInfoRecordsVo;
import zust.online.crp.entity.vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    UserVo refreshToken(HttpServletRequest httpServletRequest);

    Boolean logout(HttpServletRequest httpServletRequest);

    List<UserInfoRecordsVo> getUserInfoRecords();

    String saveBackground(String background);

    UserVo getById(Long userId, boolean detailed);

    boolean follow(Long userId);

    List<UserVo> getFansList(Long userId);
}
