package org.liki.member.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.liki.common")//common package 에 있는 bean 들을 scan 하기 위해 추가
public class MemberConfig {

}
