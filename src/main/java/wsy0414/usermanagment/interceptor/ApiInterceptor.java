package wsy0414.usermanagment.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import wsy0414.usermanagment.entity.UserInfo;
import wsy0414.usermanagment.mapper.user.UserMapper;
import wsy0414.usermanagment.util.JwtUtil;

@Component
public class ApiInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if(isLogin(request.getRequestURI())){
            return true;
        }

        String token = request.getHeader("Authorization");
        token = token.replace("Bearer", "");

        int userId = JwtUtil.verifyToken(token);

        UserInfo userInfo = userMapper.getUserById(userId);
        token = JwtUtil.generateToken(userInfo);
        response.addHeader("Authorization", "Bearer" + token);
        
        return true;
    }

    private boolean isLogin(String requestUrl) {
        return StringUtils.equals("/api/login", requestUrl);
    }
    
}
