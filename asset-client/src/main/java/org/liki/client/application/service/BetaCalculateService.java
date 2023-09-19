package org.liki.client.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.liki.client.adapter.out.persistence.entity.MemberCashJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;
import org.liki.client.application.port.in.BetaCalculateUseCase;
import org.liki.client.application.port.out.GetMemberCashPort;
import org.liki.client.application.port.out.GetMemberPort;
import org.liki.client.application.port.out.GetMemberPortfolioPort;
import org.liki.client.application.port.out.GetStockInfoByTickersPort;
import org.liki.common.UseCase;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@UseCase
public class BetaCalculateService implements BetaCalculateUseCase {

  private final GetMemberPort getMemberPort;

  private final GetStockInfoByTickersPort getStockInfoByTickersPort;

  private final GetMemberPortfolioPort getMemberPortfolioPort;

  private final GetMemberCashPort getMemberCashPort;

  @Override
  public void calculateBeta(Long memberId) {

    memberId = 10L;

    //member 조회
    MemberJpaEntity member = getMemberPort.getMember(memberId);

    //memberPortfolio 조회
    List<MemberPortfolioJpaEntity> memberPortfolio = getMemberPortfolioPort.getMemberPortfolio(memberId);

    MemberCashJpaEntity memberCash = getMemberCashPort.getMemberCash(memberId);

    //beta 값 구하기

    //beta 값 리턴

  }


}
