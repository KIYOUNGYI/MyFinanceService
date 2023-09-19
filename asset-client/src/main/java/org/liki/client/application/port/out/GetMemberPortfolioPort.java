package org.liki.client.application.port.out;

import java.util.List;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;

public interface GetMemberPortfolioPort {

  List<MemberPortfolioJpaEntity> getMemberPortfolio(Long memberId);

}
