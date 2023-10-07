package org.liki.client.application.port.in;

import java.util.List;
import org.liki.client.domain.MemberPortfolio;

public interface RegisterMemberPortfolioUseCase {

  List<MemberPortfolio> registerMemberPortfolio(RegisterMemberPortfolioCommand build);
}
