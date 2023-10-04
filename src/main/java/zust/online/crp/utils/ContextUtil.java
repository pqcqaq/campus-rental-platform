package zust.online.crp.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import zust.online.crp.entity.po.User;

/**
 * @author qcqcqc
 */
@Component
public class ContextUtil {
    public static User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!(principal instanceof User user)) {
            return null;
        }
        return user;
    }
}
