package org.liki.client.application.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BetaCalculateServiceTest {

  @Autowired
  private BetaCalculateService betaCalculateService;


  @Test
  void test() {
    betaCalculateService.calculateBeta(78L);
  }

}