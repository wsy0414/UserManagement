package wsy0414.usermanagment.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wsy0414.usermanagment.entity.UserInfo;
import wsy0414.usermanagment.util.JwtUtil;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @GetMapping("/")
    public Object getToken(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        return ResponseEntity.ok(map);
    }
}
