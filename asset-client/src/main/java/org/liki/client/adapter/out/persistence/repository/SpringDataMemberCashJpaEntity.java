package org.liki.client.adapter.out.persistence.repository;

import org.liki.client.adapter.out.persistence.entity.MemberCashJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMemberCashJpaEntity extends JpaRepository<MemberCashJpaEntity, Long> {

}
