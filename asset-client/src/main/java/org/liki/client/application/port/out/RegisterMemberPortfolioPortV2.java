package org.liki.client.application.port.out;

import java.util.List;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioV2JpaEntity;
import org.liki.client.application.port.in.MemberPortfolioCommandV2;

public interface RegisterMemberPortfolioPortV2 {

  List<MemberPortfolioV2JpaEntity> createMemberPortfolioV2(List<MemberPortfolioCommandV2> memberPortfolioCommandList);
}
