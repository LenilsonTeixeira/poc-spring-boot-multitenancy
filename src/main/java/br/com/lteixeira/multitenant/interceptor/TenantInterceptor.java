package br.com.lteixeira.multitenant.interceptor;

import br.com.lteixeira.multitenant.config.TenantContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class TenantInterceptor implements HandlerInterceptor {

    public static final String TENANT = "x-tenant";


    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
        Optional.ofNullable(req.getHeader(TENANT))
                .map(String::toLowerCase)
                .ifPresent(TenantContext::setCurrentTenant);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        TenantContext.clear();
    }

}
