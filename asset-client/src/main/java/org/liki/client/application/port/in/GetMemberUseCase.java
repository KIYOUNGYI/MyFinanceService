package org.liki.client.application.port.in;

import org.liki.client.domain.Member;

public interface GetMemberUseCase {

  Member getMember(GetMemberCommand command);
}
