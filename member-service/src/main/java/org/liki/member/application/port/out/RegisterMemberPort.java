package org.liki.member.application.port.out;

import org.liki.member.adapter.out.persistence.MemberJpaEntity;
import org.liki.member.domain.Member;

public interface RegisterMemberPort {

  MemberJpaEntity createMember(
      Member.MemberName membershipName,
      Member.MemberEmail membershipEmail,
      Member.MemberIsValid membershipIsValid
  );
}
