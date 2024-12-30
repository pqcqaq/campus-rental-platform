package zust.online.crp.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * @author qcqcqc
 * 代理对象工具类
 * 用于获取自己的代理对象
 * 主要用于解决自调用问题
 */
public class ProxyUtil {

    private static ApplicationContext applicationContext;

    public static  <T> T getBean(Class<T> clazz) {
        if (applicationContext == null) {
            throw new RuntimeException("applicationContext is null");
        }
        return applicationContext.getBean(clazz);
    }

    public static  <T> T getSelfProxied(T bean) {
        if (applicationContext != null) {
            Class<T> aClass = (Class<T>) bean.getClass();
            return applicationContext.getBean(aClass);
        } else {
            throw new RuntimeException("applicationContext is null");
        }
    }
    public static void setApplicationContextStatic(ApplicationContext applicationContext) throws BeansException {
        ProxyUtil.applicationContext = applicationContext;
    }
}
