/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smart_healthcare;

import io.jsonwebtoken.*;
import java.util.Date;

/**
 *
 * @author vinicius
 */

public class JwtUtil {
    private static final String SECRET_KEY = "your-256-bit-secret";

    public static String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 3600_000)) // 1 hour
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact();
    }

    public static Claims validateToken(String token) throws JwtException {
        return Jwts.parser()
            .setSigningKey(SECRET_KEY)
            .parseClaimsJws(token)
            .getBody();
    }
}
