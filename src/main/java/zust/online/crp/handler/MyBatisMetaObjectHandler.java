package zust.online.crp.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import zust.online.crp.entity.po.User;

import java.util.Date;

/**
 * @author qcqcqc
 */
@Component
public class MyBatisMetaObjectHandler implements MetaObjectHandler {

    /**
     * 获取username，如果获取不到则返回null，不会写入数据库
     */
    private Long getUsername() {
        // 获取security上下文
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = (User) authentication.getPrincipal();
            return user.getId();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 自定义插入时填充规则
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 注意是类属性字段名称，不是表字段名称
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);

        // 设置创建人
        this.setFieldValByName("createBy", getUsername(), metaObject);
    }

    /**
     * 自定义更新时填充规则
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 注意是类属性字段名称，不是表字段名称
        this.setFieldValByName("updateTime", new Date(), metaObject);

        // 设置更新人
        this.setFieldValByName("updateBy", getUsername(), metaObject);
    }

}
