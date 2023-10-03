package org.liki.client.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;
import lombok.RequiredArgsConstructor;
import org.liki.client.domain.AuthPayload;
import org.liki.client.domain.JwtTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtProvider {

  @Value("${jwt.password}")
  private String secretKey;

  private final ObjectMapper objectMapper;


  //==토큰 생성 메소드==//
  public JwtTokenResponse createToken(Long idRegister) {
    Date now = new Date();
    Date expiration = new Date(now.getTime() + Duration.ofDays(30).toMillis()); // 만료기간 30일
//    Claims claims = Jwts.claims().setSubject(subject);


    AuthPayload payload = new AuthPayload();
    payload.setEmail("yky2798@gmail.com");
    payload.setMemberId(10L);

    try {

      String accessToken = Jwts.builder()
          .setSubject("auth")
          .claim("payload", payload)
          .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secretKey.getBytes()))
          .setIssuedAt(now)
          .setExpiration(expiration)
          .compact();

      String refreshToken = Jwts.builder()
          .setSubject("refresh")
          .claim("idRegister", 10L)
          .signWith(SignatureAlgorithm.HS256, secretKey)
          .compact();

      return new JwtTokenResponse(accessToken, refreshToken, payload);

    } catch (RuntimeException e) {
      throw new RuntimeException(e);
    }

//    return Jwts.builder()
//        .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // (1)
//        .setIssuer("test") // 토큰발급자(iss)
//        .setIssuedAt(now) // 발급시간(iat)
//        .setExpiration(expiration) // 만료시간(exp)
//        .setSubject(subject) //  토큰 제목(subject요)
////        .setClaims(claims)
//        .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secretKey.getBytes())) // 알고리즘, 시크릿 키
//        .compact();

//    return null;
  }

  public JwtTokenResponse createToken(Long idRegister, String email) {
    Date now = new Date();
    Date expiration = new Date(now.getTime() + Duration.ofDays(30).toMillis()); // 만료기간 30일


    AuthPayload payload = new AuthPayload();
    payload.setEmail(email);
    payload.setMemberId(idRegister);

    try {

      String accessToken = Jwts.builder()
          .setSubject("auth")
          .claim("payload", payload)
          .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secretKey.getBytes()))
          .setIssuedAt(now)
          .setExpiration(expiration)
          .compact();

      String refreshToken = Jwts.builder()
          .setSubject("refresh")
          .claim("idRegister", idRegister)
          .signWith(SignatureAlgorithm.HS256, secretKey)
          .compact();

      return new JwtTokenResponse(accessToken, refreshToken, payload);

    } catch (RuntimeException e) {
      throw new RuntimeException(e);
    }

  }

  public Long parseJwtTokenAndReturnMemberId(String token) {

    Claims claims = parseJwtToken(token);
    LinkedHashMap payload = (LinkedHashMap) claims.get("payload");

    Integer memberId = (Integer) payload.get("memberId");

    long l = Integer.toUnsignedLong(memberId);

    return l;
  }

  public AuthPayload parseJwtTokenAndReturnMember(String token) {

    Claims claims = parseJwtToken(token);
    LinkedHashMap payload = (LinkedHashMap) claims.get("payload");

    Integer memberId = (Integer) payload.get("memberId");

    long l = Integer.toUnsignedLong(memberId);
    String email = (String) payload.get("email");

    AuthPayload authPayload = new AuthPayload();
    authPayload.setMemberId(l);
    authPayload.setEmail(email);

    return authPayload;
  }



  //==Jwt 토큰의 유효성 체크 메소드==//
  public Claims parseJwtToken(String token) {
    token = BearerRemove(token); // Bearer 제거
    return Jwts.parser()
        .setSigningKey(Base64.getEncoder().encodeToString(secretKey.getBytes()))
        .parseClaimsJws(token)
        .getBody();
  }

  //==토큰 앞 부분('Bearer') 제거 메소드==//
  private String BearerRemove(String token) {
    return token.substring("Bearer ".length());
  }
}
