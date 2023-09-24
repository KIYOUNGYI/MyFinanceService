package org.liki.member.application.port.in;

import org.liki.member.domain.TokenResponse;

public interface CreateMemberJwtTokenUseCase {

  TokenResponse createToken(Long memberId);

  Object createToken(String email);
}
