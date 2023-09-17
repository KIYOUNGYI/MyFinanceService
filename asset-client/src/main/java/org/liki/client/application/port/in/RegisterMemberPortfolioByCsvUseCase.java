package org.liki.client.application.port.in;

import org.liki.client.domain.Member;
import org.springframework.web.multipart.MultipartFile;

public interface RegisterMemberPortfolioByCsvUseCase {

  void registerMemberPortfolioByCsvFile(Member member, MultipartFile file);
}
