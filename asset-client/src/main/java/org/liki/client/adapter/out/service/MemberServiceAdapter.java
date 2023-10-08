package org.liki.client.adapter.out.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.liki.client.domain.Member;
import org.liki.common.CommonHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceAdapter {

  private final CommonHttpClient commonHttpClient;

  private final String membershipServiceUrl;

  public MemberServiceAdapter(CommonHttpClient commonHttpClient,
      @Value("${service.member.url}") String membershipServiceUrl) {
    this.commonHttpClient = commonHttpClient;
    this.membershipServiceUrl = membershipServiceUrl;
  }


  public Member getMemberByMemberId(Long memberId) {
    try {

      String body = commonHttpClient.sendGetRequest(membershipServiceUrl + "/api/member/" + memberId).body();
      System.out.println("body = " + body);
      ObjectMapper objectMapper = new ObjectMapper();
      Member member = objectMapper.readValue(body, Member.class);

      return member;
      // {"memberId":"10","memberName":"Liki","email":"yky2798@gmail.com","valid":true}


    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
