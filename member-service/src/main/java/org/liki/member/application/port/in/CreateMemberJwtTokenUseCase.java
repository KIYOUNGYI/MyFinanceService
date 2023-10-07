package org.liki.member.application.port.in;

import org.liki.member.domain.JwtTokenResponse;

public interface CreateMemberJwtTokenUseCase {

  JwtTokenResponse createToken(Long memberId);

  JwtTokenResponse createToken(Long memberId, String email);

  Object createToken(String email);
}
