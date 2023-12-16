package org.liki.client.adapter.out.persistence.repository;

import org.liki.client.adapter.out.persistence.entity.MemberCashJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberCashV2JpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMemberCashV2JpaRepository extends JpaRepository<MemberCashV2JpaEntity, Long> {

}
