package org.liki.client.adapter.out.persistence.repository;

import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMembershipRepository extends JpaRepository<MemberJpaEntity, Long> {

}
