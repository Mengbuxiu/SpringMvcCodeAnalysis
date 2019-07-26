package cn.zl.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alin
 * @version 1.0
 * @description // 访问拦截
 * @date 2019/7/19 15:37
 */
public class AccessChain1Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Access----------Chain----1-------");
        return true;
    }
}
