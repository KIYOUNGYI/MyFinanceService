package org.liki.member.application.service;


import lombok.RequiredArgsConstructor;
import org.liki.common.UseCase;
import org.liki.member.application.port.in.CreateMemberJwtTokenUseCase;
import org.liki.member.application.port.in.GetMemberCommand;
import org.liki.member.application.port.in.GetMemberUseCase;
import org.liki.member.config.JwtProvider;
import org.liki.member.domain.JwtTokenResponse;
import org.liki.member.domain.Member;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class CreateMemberJwtTokenService implements CreateMemberJwtTokenUseCase {

  private final JwtProvider jwtProvider;

  private final GetMemberUseCase getMemberUseCase;

  @Override
  public JwtTokenResponse createToken(Long memberId) {

    //memberPort 에서 가져오거나, memberService 에서 가져오거나
    Member member = getMemberUseCase.getMember(GetMemberCommand.builder().id(memberId).build());

    JwtTokenResponse token = jwtProvider.createToken(Long.valueOf(member.getMemberId()), member.getEmail());


    return token;
  }

  @Override
  public JwtTokenResponse createToken(Long memberId, String email) {
    JwtTokenResponse token = jwtProvider.createToken(memberId, email);
    return token;
  }

  @Override
  public Object createToken(String email) {
    return null;
  }
}
