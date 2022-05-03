package com.springsecurity.swagger.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class ClientConfiguration {

  @Value("${userapispecification.security.authorization.key:}")
  private String authorizationKey;

  @Bean
  @ConditionalOnProperty(name = "userapispecification.security.authorization.key")
  public ApiKeyRequestInterceptor authorizationRequestInterceptor() {
    return new ApiKeyRequestInterceptor("header", "Authorization", this.authorizationKey);
  }

}
