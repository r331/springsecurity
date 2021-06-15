package ru.sber.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import ru.sber.security.customer.Role;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTTokenService {
    private final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static String createJWT(String name, Role role) {

        Map<String, Object> map = new HashMap<>();
        map.put("role", role.name());
        return Jwts.builder()
                .setSubject(name)
                .addClaims(map)
                .signWith(key)
                .compact();
    }

    public boolean verify(String jwsString){
        Jws<Claims> s = Jwts.parserBuilder()
                .setSigningKey(key) // <----
                .build()
                .parseClaimsJws(jwsString);
        return true;

    }
}
