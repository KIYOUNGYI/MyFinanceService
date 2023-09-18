package org.liki.client.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;
import org.liki.client.adapter.out.persistence.repository.SpringDataMemberPortfolioJpaEntity;
import org.liki.client.application.port.in.MemberPortfolioCommand;
import org.liki.client.application.port.out.RegisterMemberPortfolioPort;
import org.liki.client.domain.Member;
import org.liki.common.PersistenceAdapter;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class MemberPortfolioPersistenceAdapter implements RegisterMemberPortfolioPort {

  private final SpringDataMemberPortfolioJpaEntity springDataMemberPortfolioJpaEntity;


  @Override
  public List<MemberPortfolioJpaEntity> createMemberPortfolio(List<MemberPortfolioCommand> memberPortfolioCommandList) {

    List<MemberPortfolioJpaEntity> list = new ArrayList<>();

    for (MemberPortfolioCommand command : memberPortfolioCommandList) {

      MemberPortfolioJpaEntity entity = MemberPortfolioJpaEntity.builder()
          .memberJpaEntity(command.getMemberJpaEntity())
          .stockInfoJpaEntity(command.getStockInfoJpaEntity())
          .stockCount(command.getCount())
          .averagePrice(command.getAvgPrice())
          .build();

      list.add(entity);
    }

    List<MemberPortfolioJpaEntity> memberPortfolioJpaEntities = springDataMemberPortfolioJpaEntity.saveAll(list);

    return memberPortfolioJpaEntities;
  }
}
