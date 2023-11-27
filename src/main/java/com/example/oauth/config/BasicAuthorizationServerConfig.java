//package com.example.oauth.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//
//@Order(2)
//@Configuration
//public class BasicAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients
//                .inMemory()
//                .withClient("ys-oauth")
//                .secret(passwordEncoder().encode("pion12345"))
//                .scopes("resource:read", "resource:write")
//                .authorizedGrantTypes("authorization_code", "client_credentials")
//                .redirectUris("http://localhost:8081/");
//    }
//
//}
