package org.liki.client.adapter.out.persistence.repository;

import java.util.List;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;

public interface SpringDataMemberPortfolioCustomRepository {

  void deleteMemberPortfolioByMemberId(Long memberId);

  List<MemberPortfolioJpaEntity> getMemberPortfolioByMemberId(Long memberId);
}
