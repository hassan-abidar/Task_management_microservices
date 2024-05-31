package hassan.abidar.taskuserservice.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.util.*;

public class JwtProvider {
    static SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SERCRET_KEY.getBytes());
    public static String generateToken(Authentication authentication){
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String roles = populateAuthorities(authorities);
        String jwt = Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+86400000))
                .claim("email",authentication.getName())
                .claim("authorities",roles)
                .signWith(key)
                .compact();
    return jwt;
    }
    public static String getEmailFromJwtToken(String jwt){
        jwt=jwt.substring(7);
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
        String email = String.valueOf(claims.get("email"));
        return email;
    }

    private static String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
        Set<String> auths = new HashSet<>();
        for(GrantedAuthority authority : collection){
            auths.add(authority.getAuthority());
        }
        return String.join(",",auths);

    }
}
