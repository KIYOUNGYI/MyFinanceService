package org.liki.member.adapter.out.persistence;


import lombok.RequiredArgsConstructor;
import org.liki.common.PersistenceAdapter;
import org.liki.member.application.port.out.GetMemberPort;
import org.liki.member.application.port.out.RegisterMemberPort;
import org.liki.member.domain.Member.MemberEmail;
import org.liki.member.domain.Member.MemberIsValid;
import org.liki.member.domain.Member.MemberName;
import org.springframework.stereotype.Component;

@PersistenceAdapter
@RequiredArgsConstructor
@Component
public class MemberPersistenceAdapter implements RegisterMemberPort, GetMemberPort {

  private final SpringDataMembershipRepository membershipRepository;


  @Override
  public MemberJpaEntity createMember(MemberName membershipName, MemberEmail membershipEmail, MemberIsValid membershipIsValid) {

    return membershipRepository.save(
        new MemberJpaEntity(
            membershipName.getName(),
            membershipEmail.getEmailValue(),
            membershipIsValid.isValidValue()
        )
    );
  }

  @Override
  public MemberJpaEntity getMember(Long id) {

    return membershipRepository.findById(id).orElseThrow();
  }
}
