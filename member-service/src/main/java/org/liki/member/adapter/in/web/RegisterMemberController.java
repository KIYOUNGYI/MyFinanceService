package org.liki.member.adapter.in.web;


import lombok.RequiredArgsConstructor;
import org.liki.common.WebAdapter;
import org.liki.member.application.port.in.RegisterMemberCommand;
import org.liki.member.application.port.in.RegisterMemberUseCase;
import org.liki.member.domain.Member;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMemberController {

  private final RegisterMemberUseCase registerMemberUseCase;

  @PostMapping("/api/member")
  Member registerMembership(@RequestBody RegisterMembershipRequest request) {

    RegisterMemberCommand command = RegisterMemberCommand.builder()
        .memberName(request.getMemberName())
        .email(request.getEmail())
        .isValid(true)
        .build();

    return registerMemberUseCase.registerMember(command);

  }
}
