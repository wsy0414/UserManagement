package wsy0414.usermanagment.util;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import wsy0414.usermanagment.entity.UserInfo;

public class JwtUtil {
    private static final String KEY = "shuoyiForStudy123rwfq4r244c5qwer12dc125c12rc12rqer123";

    public static String generateToken(UserInfo userInfo) {
        Claims claims = Jwts.claims();
        claims.put("userId", userInfo.getUserId());

        Key secretKey = Keys.hmacShaKeyFor(KEY.getBytes());
        
        String token = Jwts.builder().setClaims(claims).signWith(secretKey).compact();

        return token;
    }

    public static int verifyToken(String token) {
        Key secretKey = Keys.hmacShaKeyFor(KEY.getBytes());

        JwtParser parser = Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build();
        Claims claims = parser.parseClaimsJws(token).getBody();
        int userId = (int)((double) claims.get("userId"));
        return userId;
    }
}
