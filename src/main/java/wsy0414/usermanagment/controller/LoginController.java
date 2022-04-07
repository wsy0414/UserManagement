package wsy0414.usermanagment.controller;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wsy0414.usermanagment.entity.UserInfo;
import wsy0414.usermanagment.service.LoginService;
import wsy0414.usermanagment.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;
    
    @PostMapping("/login")
    public Object login(@RequestBody UserInfo userInfo, HttpServletResponse response) throws AuthException {
        String token = loginService.login(userInfo);

        response.addHeader("Authorization", "Bearer" + token );
        return ResponseEntity.ok(userInfo);
    }
}
