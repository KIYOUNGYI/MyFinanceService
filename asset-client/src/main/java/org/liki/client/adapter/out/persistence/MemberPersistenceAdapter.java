package org.liki.client.adapter.out.persistence;


import lombok.RequiredArgsConstructor;
import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;
import org.liki.client.adapter.out.persistence.repository.SpringDataMembershipRepository;
import org.liki.client.application.port.out.GetMemberPort;
import org.liki.common.PersistenceAdapter;
import org.springframework.stereotype.Component;

@PersistenceAdapter
@RequiredArgsConstructor
@Component
public class MemberPersistenceAdapter implements GetMemberPort {

  private final SpringDataMembershipRepository membershipRepository;


  @Override
  public MemberJpaEntity getMember(Long id) {

    return membershipRepository.findById(id).orElseThrow();
  }
}
