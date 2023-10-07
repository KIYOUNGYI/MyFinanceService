package org.liki.member.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.liki.common.WebAdapter;
import org.liki.member.application.port.in.CreateMemberJwtTokenUseCase;
import org.liki.member.application.port.in.GetMemberCommand;
import org.liki.member.application.port.in.GetMemberUseCase;
import org.liki.member.application.service.GetMembershipService;
import org.liki.member.domain.JwtTokenResponse;
import org.liki.member.domain.Member;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class CreateMemberJwtTokenController {

  private final CreateMemberJwtTokenUseCase createMemberJwtTokenUseCase;
  private final GetMemberUseCase getMemberUseCase;


  @PostMapping("/api/tokenCreate/{memberId}")
  public JwtTokenResponse createToken(@PathVariable Long memberId) {

    Member member = getMemberUseCase.getMember(GetMemberCommand.builder().id(memberId).build());
    System.out.println("member = " + member);
    JwtTokenResponse token = createMemberJwtTokenUseCase.createToken(memberId);

    return token;
  }
}
