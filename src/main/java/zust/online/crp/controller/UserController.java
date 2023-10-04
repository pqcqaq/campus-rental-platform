package zust.online.crp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.dto.LoginParam;
import zust.online.crp.entity.vo.UserVo;
import zust.online.crp.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author qcqcqc
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<UserVo> login(@RequestBody LoginParam loginParam) {
        return userService.login(loginParam);
    }

    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest httpServletRequest) {
        Boolean logout = userService.logout(httpServletRequest);
        if (!logout) {
            return Result.error(500, "退出失败");
        }
        return Result.success("退出成功");
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/alter")
    public Result<UserVo> alter(@Valid @RequestBody UserVo userVo) {
        return Result.success("修改成功", userService.alter(userVo));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/saveAlterAvatar")
    public Result<String> saveAlterAvatar(@RequestBody String avatar) {
        return Result.success("修改成功", userService.saveAlterAvatar(avatar));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/refreshToken")
    public Result<UserVo> refreshToken(HttpServletRequest httpServletRequest) {
        UserVo userVo = userService.refreshToken(httpServletRequest);
        return Result.success("刷新成功", userVo);
    }
}
