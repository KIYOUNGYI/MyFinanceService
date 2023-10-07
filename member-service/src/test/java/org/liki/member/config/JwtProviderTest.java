package org.liki.member.config;

import static org.junit.jupiter.api.Assertions.*;

import io.jsonwebtoken.Claims;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;
import org.liki.member.application.port.in.GetMemberCommand;
import org.liki.member.application.service.GetMembershipService;
import org.liki.member.domain.AuthPayload;
import org.liki.member.domain.JwtTokenResponse;
import org.liki.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtProviderTest {

  @Autowired
  private GetMembershipService getMembershipService;

  @Autowired
  private JwtProvider jwtProvider;

  @Test
  void createToken() {
    Member member = getMembershipService.getMember(GetMemberCommand.builder().id(78L).build());
    System.out.println("member = " + member);
    JwtTokenResponse token = jwtProvider.createToken(Long.valueOf(member.getMemberId()), member.getEmail());
    System.out.println("token = " + token);
    String access_token = token.getAccess_token();
    System.out.println("=================================");
    Claims claims = jwtProvider.parseJwtToken("Bearer "+access_token);
    System.out.println("claims = " + claims);

//    AuthPayload payload = (AuthPayload) claims.get("payload");
    System.out.println("claims = " + claims.get("payload"));

    LinkedHashMap payload = (LinkedHashMap) claims.get("payload");
    System.out.println("payload = " + payload);

    Integer memberId = (Integer) payload.get("memberId");
//    System.out.println("memberId = " + memberId);

    System.out.println("memberId = " + memberId);
    long l = Integer.toUnsignedLong(memberId);
    System.out.println("unsigned Long = " + l);
    String email = (String) payload.get("email");
    System.out.println("email = " + email);

  }
}