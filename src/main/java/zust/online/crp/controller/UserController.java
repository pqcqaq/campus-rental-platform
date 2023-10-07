package zust.online.crp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.dto.LoginParam;
import zust.online.crp.entity.vo.UserInfoRecordsVo;
import zust.online.crp.entity.vo.UserVo;
import zust.online.crp.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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
    @PostMapping("/saveAlterBackground")
    public Result<String> saveBackground(@RequestBody String background) {
        return Result.success("修改成功", userService.saveBackground(background));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/refreshToken")
    public Result<UserVo> refreshToken(HttpServletRequest httpServletRequest) {
        UserVo userVo = userService.refreshToken(httpServletRequest);
        return Result.success("刷新成功", userVo);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/getUserInfoRecords")
    public Result<List<UserInfoRecordsVo>> getUserInfoRecords() {
        return Result.success(userService.getUserInfoRecords());
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/follow/{userId}")
    public Result<Boolean> follow(@PathVariable Long userId) {
        boolean f = userService.follow(userId);
        if (f) {
            return Result.success(200, "关注成功", true);
        }
        return Result.success(200, "取消关注成功", false);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{userId}")
    public Result<UserVo> getUserDetails(@PathVariable Long userId) {
        return Result.success(userService.getById(userId, true));
    }
}
