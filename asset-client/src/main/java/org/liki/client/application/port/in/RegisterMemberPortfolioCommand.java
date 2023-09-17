package org.liki.client.application.port.in;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterMemberPortfolioCommand {

  private List<MemberPortfolioCommand> memberPortfolioCommandList;
}
