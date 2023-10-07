package org.liki.member.adapter.in.web;


import lombok.RequiredArgsConstructor;
import org.liki.common.WebAdapter;
import org.liki.member.application.port.in.GetMemberCommand;
import org.liki.member.application.port.in.GetMemberUseCase;
import org.liki.member.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class RetrieveMemberController {

  private final GetMemberUseCase getMemberUseCase;

  @GetMapping("/api/member/{id}")
  Member getMember(@PathVariable Long id) {

    GetMemberCommand command = GetMemberCommand.builder().id(id).build();

    return getMemberUseCase.getMember(command);

  }
}
