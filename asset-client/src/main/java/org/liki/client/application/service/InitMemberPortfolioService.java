package org.liki.client.application.service;

import lombok.RequiredArgsConstructor;
import org.liki.client.application.port.in.InitMemberPortfolioCommand;
import org.liki.client.application.port.in.InitMemberPortfolioUseCase;
import org.liki.client.application.port.out.InitMemberPortfolioPort;
import org.liki.common.UseCase;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@Transactional
@RequiredArgsConstructor
public class InitMemberPortfolioService implements InitMemberPortfolioUseCase {

  private final InitMemberPortfolioPort initMemberPortfolioPort;

  @Override
  public void initMemberPortfolio(InitMemberPortfolioCommand request) {

    initMemberPortfolioPort.initMemberPortfolio(request.getMemberId());
  }


}
