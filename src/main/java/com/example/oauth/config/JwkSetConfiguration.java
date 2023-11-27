package com.example.oauth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.security.KeyPair;
import java.util.Arrays;

@Order(1)
@Configuration
@RequiredArgsConstructor
public class JwkSetConfiguration extends AuthorizationServerConfigurerAdapter {

    private final KeyPair keyPair;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthorizationServerTokenServices tokenService () {
        DefaultTokenServices serv = new DefaultTokenServices();
        serv.setAccessTokenValiditySeconds(60);
        serv.setRefreshTokenValiditySeconds(3600 * 6); // 6 hours
        serv.setTokenStore(tokenStore());
        TokenEnhancerChain chain = new TokenEnhancerChain();
        chain.setTokenEnhancers(Arrays.asList(accessTokenConverter()));
        serv.setTokenEnhancer(chain);
        serv.setSupportRefreshToken(true);
        return serv;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("ys-oauth")
                .secret(passwordEncoder().encode("pion12345"))
                .scopes("resource:read", "resource:write")
                .authorizedGrantTypes("authorization_code", "client_credentials")
                .redirectUris("http://localhost:8081/result");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .accessTokenConverter(accessTokenConverter())
//                .tokenStore(tokenStore());
                .tokenServices(tokenService());
    }



    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setKeyPair(this.keyPair);
        return tokenConverter;
    }



    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

}
