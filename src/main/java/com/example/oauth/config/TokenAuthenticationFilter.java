//package com.example.oauth.config;
//
//import lombok.RequiredArgsConstructor;
//import org.apache.logging.log4j.util.Strings;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Objects;
//
//
//@Configuration
//@RequiredArgsConstructor
//public class TokenAuthenticationFilter extends OncePerRequestFilter {
//
//
//    private final UserDetailsService userDetailsService;
//
////    @Override
////    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
////        String token = extractToken(request);
////        if (Strings.isEmpty(token)) {
////            filterChain.doFilter(request, response);
////            return;
////        }
////
////        UserDetails endpoointuser = userDetailsService.loadUserByUsername("endpoointuser");
////
////        if(Objects.nonNull(endpoointuser)) {
////            String username = endpoointuser.getUsername();
////            String password = endpoointuser.getPassword();
////            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, password));
////            filterChain.doFilter(request, response);
////        }
////
////    }
//
//
//    private String extractToken(HttpServletRequest request) {
//        return request.getHeader(HttpHeaders.AUTHORIZATION);
//    }
//
//    private boolean validationToken(String token) {
//        return StringUtils.isEmpty(token);
//    }
//}
