package org.liki.client.adapter.out.persistence;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;
import org.liki.client.adapter.out.persistence.repository.SpringDataMemberPortfolioJpaEntity;
import org.liki.client.application.port.in.MemberPortfolioCommand;
import org.liki.client.application.port.out.RegisterMemberPortfolioPort;
import org.liki.common.PersistenceAdapter;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class MemberPortfolioPersistenceAdapter implements RegisterMemberPortfolioPort {

  private final SpringDataMemberPortfolioJpaEntity springDataMemberPortfolioJpaEntity;


  @Override
  public List<MemberPortfolioJpaEntity> createMemberPortfolio(List<MemberPortfolioCommand> memberPortfolioCommandList) {



    return null;
  }
}
