package org.liki.client.adapter.out.persistence;

import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;
import org.liki.client.domain.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

  public static Member jpaEntityToDomain(MemberJpaEntity memberJpaEntity){
        return Member.generateMember(
            new Member.MemberId(memberJpaEntity.getMemberId()),
            new Member.MemberName(memberJpaEntity.getName()),
            new Member.MemberEmail(memberJpaEntity.getEmail()),
            new Member.MemberIsValid(memberJpaEntity.isValid())
        );

  }

}
