package org.liki.member.application.service;


import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.liki.common.UseCase;
import org.liki.member.application.port.in.CreateMemberJwtTokenUseCase;
import org.liki.member.config.JwtProvider;
import org.liki.member.domain.TokenDataResponse;
import org.liki.member.domain.TokenResponse;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class CreateMemberJwtTokenService implements CreateMemberJwtTokenUseCase {

  private final JwtProvider jwtProvider;


  @Override
  public TokenResponse createToken(Long memberId) {

    String token = jwtProvider.createToken(String.valueOf(memberId));
    Claims claims = jwtProvider.parseJwtToken("Bearer "+ token); // 토큰 검증

    TokenDataResponse tokenDataResponse = new TokenDataResponse(token, claims.getSubject(), claims.getIssuedAt().toString(), claims.getExpiration().toString());
    TokenResponse tokenResponse = new TokenResponse("200", "OK", tokenDataResponse);

    return tokenResponse;
  }

  @Override
  public Object createToken(String email) {
    return null;
  }
}
