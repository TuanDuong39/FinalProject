//package com.example.market.Config;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.spec.SecretKeySpec;
//import java.security.Key;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//@Service
//public class JwtService {
//    public static final String SECRET_KEY = "f497994367e376e109684f16b972de2d2c19b3afbd5cd8acb21e8fb9812e77aa";
//
//    // 1. generate toke
//    public String generateToken(
//            Map<String, Object> extraClaims,
//            UserDetails userDetails
//    ) {
//        if (extraClaims == null) {
//            extraClaims = new HashMap<>();
//        }
//        return Jwts
//                .builder()
//                .setClaims(extraClaims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt( new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*15))
//                .signWith(SignatureAlgorithm.HS256, getSignInKey())
//                .compact();
//    }
//
//    public String generateToken(UserDetails userDetails) {
//        return generateToken(null,userDetails);
//    }
//
//    private Key getSignInKey() {
//        byte[] keyBytes = SECRET_KEY.getBytes();
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    // 2. extract toke
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    public String extractUsername(String token) {
//        return extractClaims(token, Claims::getSubject);
//    }
//
//    public boolean isTokenValid(String token, UserDetails userDetails) {
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
//    }
//
//    public boolean isTokenExpired(String token) {
//        return extractExpired(token).before(new Date());
//    }
//
//    public Date extractExpired(String token) {
//
//        return extractClaims(token, Claims::getExpiration);
//    }
//}
