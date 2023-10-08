package org.liki.client.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioV2JpaEntity;
import org.liki.client.adapter.out.persistence.repository.SpringDataMemberPortfolioCustomRepository;
import org.liki.client.adapter.out.persistence.repository.SpringDataMemberPortfolioJpaEntity;
import org.liki.client.application.port.in.MemberPortfolioCommand;
import org.liki.client.application.port.in.MemberPortfolioCommandV2;
import org.liki.client.application.port.out.GetMemberPortfolioPort;
import org.liki.client.application.port.out.InitMemberPortfolioPort;
import org.liki.client.application.port.out.RegisterMemberPortfolioPort;
import org.liki.client.application.port.out.RegisterMemberPortfolioPortV2;
import org.liki.common.PersistenceAdapter;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class MemberPortfolioPersistenceAdapter implements RegisterMemberPortfolioPort, InitMemberPortfolioPort , GetMemberPortfolioPort , RegisterMemberPortfolioPortV2 {

  private final SpringDataMemberPortfolioJpaEntity springDataMemberPortfolioJpaEntity;

  private final SpringDataMemberPortfolioCustomRepository springDataMemberPortfolioCustomRepository;

  @Override
  public List<MemberPortfolioJpaEntity> createMemberPortfolio(List<MemberPortfolioCommand> memberPortfolioCommandList) {

    List<MemberPortfolioJpaEntity> list = new ArrayList<>();

    for (MemberPortfolioCommand command : memberPortfolioCommandList) {

      list.add(MemberPortfolioJpaEntity.builder()
          .memberJpaEntity(command.getMemberJpaEntity())
          .stockInfoJpaEntity(command.getStockInfoJpaEntity())
          .stockCount(command.getCount())
          .averagePrice(command.getAvgPrice())
          .build());
    }

    List<MemberPortfolioJpaEntity> memberPortfolioJpaEntities = springDataMemberPortfolioJpaEntity.saveAll(list);

    return memberPortfolioJpaEntities;
  }

  @Override
  public List<MemberPortfolioV2JpaEntity> createMemberPortfolioV2(List<MemberPortfolioCommandV2> memberPortfolioCommandList) {


    return null;
  }

  @Override
  public void initMemberPortfolio(Long memberId) {

    springDataMemberPortfolioCustomRepository.deleteMemberPortfolioByMemberId(memberId);

  }

  @Override
  public List<MemberPortfolioJpaEntity> getMemberPortfolio(Long memberId) {
    List<MemberPortfolioJpaEntity> list  = springDataMemberPortfolioCustomRepository.getMemberPortfolioByMemberId(memberId);
    return list;
  }
}
