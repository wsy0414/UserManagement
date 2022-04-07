package wsy0414.usermanagment.service;

import javax.security.auth.message.AuthException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wsy0414.usermanagment.entity.UserInfo;
import wsy0414.usermanagment.mapper.user.UserMapper;
import wsy0414.usermanagment.util.JwtUtil;

@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    public String login(UserInfo userInfo) throws AuthException{
        UserInfo userFromDB = userMapper.getUserByName(userInfo);

        if(userFromDB == null){
            throw new AuthException();
        }

        if(checkPwd(userFromDB.getPwd(), userInfo.getPwd())){
            return JwtUtil.generateToken(userFromDB);
        }else{
            throw new AuthException();
        }
    }

    private boolean checkPwd(String pwd1, String pwd2){
        return StringUtils.equals(pwd1, pwd2);
    }
}
