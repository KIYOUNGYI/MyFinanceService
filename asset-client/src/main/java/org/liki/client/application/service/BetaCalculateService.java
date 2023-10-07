package org.liki.client.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.MemberCashJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;
import org.liki.client.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.client.application.port.in.BetaCalculateUseCase;
import org.liki.client.application.port.out.GetMemberCashPort;
import org.liki.client.application.port.out.GetMemberPort;
import org.liki.client.application.port.out.GetMemberPortfolioPort;
import org.liki.client.application.port.out.GetStockInfoByTickersPort;
import org.liki.common.UseCase;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
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

    //member 조회
    MemberJpaEntity member = getMemberPort.getMember(memberId);

    //memberPortfolio 조회
    List<MemberPortfolioJpaEntity> memberPortfolio = getMemberPortfolioPort.getMemberPortfolio(memberId);

    MemberCashJpaEntity memberCash = getMemberCashPort.getMemberCash(memberId);

    //beta 값 구하기

    //beta 값 리턴

    log.info("memberPortfolio => " + memberPortfolio.toString());

    Double cashAmount = memberCash.getCashAmount();
    log.info("cashAmount => " + cashAmount);

    Double totalCashAmount = null;
    totalCashAmount = cashAmount;
    for (MemberPortfolioJpaEntity entity : memberPortfolio) {

      StockInfoJpaEntity stockInfoJpaEntity = entity.getStockInfoJpaEntity();

      Double previousClose = stockInfoJpaEntity.getPreviousClose();
      System.out.println("previousClose = " + previousClose);

      Long stockCount = entity.getStockCount();
      Double stockAmount = previousClose * stockCount;
      totalCashAmount += stockAmount;
    }
    System.out.println("totalCashAmount => " + totalCashAmount);

    double myBeta = 0;
    for (MemberPortfolioJpaEntity entity : memberPortfolio) {

      StockInfoJpaEntity stockInfoJpaEntity = entity.getStockInfoJpaEntity();
      Double previousClose = stockInfoJpaEntity.getPreviousClose();
      Long stockCount = entity.getStockCount();

      Double stockAmount = previousClose * stockCount;
      double weight = stockAmount / totalCashAmount;

      double weightedBetaValue = weight * stockInfoJpaEntity.getBeta();
      System.out.println("ticker : " + stockInfoJpaEntity.getTicker() + " weight = " + weight + " weightedBetaValue = " + weightedBetaValue);
      myBeta += weightedBetaValue;

    }

    System.out.println("myBeta = " + myBeta);


  }
}
