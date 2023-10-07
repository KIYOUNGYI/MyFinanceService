package org.liki.client.application.port.out;

import java.util.List;
import org.liki.client.adapter.out.persistence.entity.MemberCashJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;

public interface GetMemberCashPort {


  MemberCashJpaEntity getMemberCash(Long memberId);


}
