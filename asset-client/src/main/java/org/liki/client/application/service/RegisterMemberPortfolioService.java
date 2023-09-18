package org.liki.client.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;
import org.liki.client.application.port.in.RegisterMemberPortfolioCommand;
import org.liki.client.application.port.in.RegisterMemberPortfolioUseCase;
import org.liki.client.application.port.out.RegisterMemberPortfolioPort;
import org.liki.client.domain.MemberPortfolio;
import org.liki.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterMemberPortfolioService implements RegisterMemberPortfolioUseCase {


  private final RegisterMemberPortfolioPort registerMemberPortfolioPort;

  @Override
  public List<MemberPortfolio> registerMemberPortfolio(RegisterMemberPortfolioCommand command) {

    List<MemberPortfolioJpaEntity> memberPortfolio = registerMemberPortfolioPort.createMemberPortfolio(command.getMemberPortfolioCommandList());

    return null;
  }
}
