package org.liki.member.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.liki.common.WebAdapter;
import org.liki.member.application.port.in.CreateMemberJwtTokenUseCase;
import org.liki.member.domain.TokenResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class CreateMemberJwtTokenController {

  private final CreateMemberJwtTokenUseCase createMemberJwtTokenUseCase;


  @PostMapping("/api/tokenCreate/{memberId}")
  public TokenResponse createToken(Long memberId) {

    TokenResponse token = createMemberJwtTokenUseCase.createToken(memberId);

    return token;
  }
}
