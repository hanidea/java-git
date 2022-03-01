package com.example.demo.core.interceptors;

import com.auth0.jwt.interfaces.Claim;
import com.example.demo.exception.http.ForbiddenException;
import com.example.demo.exception.http.UnAuthenticatedException;
import com.example.demo.util.JwtToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

public class PermissionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<ScopeLevel> scopeLevel = this.getScopeLevel(handler);
        if(!scopeLevel.isPresent()) {
            return true;
        }
        String bearerToken = request.getHeader("Authorization");
        if(StringUtils.isEmpty(bearerToken)){
            throw new UnAuthenticatedException(10004);
        }
        if (!bearerToken.startsWith("Bearer")) {
            throw new UnAuthenticatedException(10004);
        }
        String tokens[] = bearerToken.split(" ");
        if (!(tokens.length == 2)) {
            throw new UnAuthenticatedException(10004);
        }
        String token = tokens[1];
        //String token = bearerToken.split(" ")[1];

        Optional<Map<String, Claim>> optionalMap = JwtToken.getClaims(token);
        Map<String,Claim> map = optionalMap.orElseThrow(() -> new UnAuthenticatedException(10004));

        boolean valid = this.hasPermission(scopeLevel.get(), map);
//        if(valid){
//            this.setToThreadLocal(map);
//        }
        return valid;
    }

    private boolean hasPermission(ScopeLevel scopeLevel, Map<String, Claim> map) {
        Integer level = scopeLevel.value();
        Integer scope = map.get("scope").asInt();
        if (level > scope) {
            throw new ForbiddenException(10005);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    private Optional<ScopeLevel> getScopeLevel(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            ScopeLevel scopeLevel = handlerMethod.getMethod().getAnnotation(ScopeLevel.class);
            if (scopeLevel == null) {
                return Optional.empty();
            }
            return Optional.of(scopeLevel);
        }
        return Optional.empty();
    }
}
