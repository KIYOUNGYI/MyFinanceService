package org.liki.client.application.port.out;


import java.util.List;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;
import org.liki.client.application.port.in.MemberPortfolioCommand;

public interface RegisterMemberPortfolioPort {


  List<MemberPortfolioJpaEntity> createMemberPortfolio(List<MemberPortfolioCommand> memberPortfolioCommandList);
}
