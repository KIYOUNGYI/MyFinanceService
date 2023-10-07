package org.liki.client.adapter.out.persistence.repository;

import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMemberPortfolioJpaEntity extends JpaRepository<MemberPortfolioJpaEntity, Long> {

}
