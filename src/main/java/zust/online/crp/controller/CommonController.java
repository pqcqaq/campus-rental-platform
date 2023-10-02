package zust.online.crp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.po.User;

/**
 * @author qcqcqc
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @PostMapping("/init")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Result<String> init() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        log.info("用户：{}，初始化成功", user.getUsername());
        return Result.success("初始化成功");
    }

    @GetMapping("/test")
    public Result<String> test() {
        return Result.success("测试成功");
    }
}
