package org.liki.client.adapter.out.persistence.repository;

import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntityV2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMemberPortfolioV2Repository extends JpaRepository<MemberPortfolioJpaEntityV2, Long> {

}
