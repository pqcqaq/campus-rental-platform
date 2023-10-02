package zust.online.crp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.dto.LoginParam;
import zust.online.crp.entity.vo.UserVo;
import zust.online.crp.service.UserService;

import javax.annotation.Resource;

/**
 * @author qcqcqc
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<UserVo> login(@RequestBody LoginParam loginParam){
        return userService.login(loginParam);
    }
}
