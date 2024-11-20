//package com.core.pilot.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
//import org.springframework.security.oauth2.core.oidc.OidcIdToken;
//import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//
//@Configuration
//@Slf4j
//public class WebSecurityConfig {
//    @Bean
//    AuthoritiesConverter realmRolesAuthoritiesConverter() {
//        return claims -> {
//            var realmAccess = Optional.ofNullable((Map<String, Object>) claims.get("realm_access"));
//            var roles = realmAccess.flatMap(map -> Optional.ofNullable((List<String>) map.get("roles")));
//            return roles.map(List::stream)
//                    .orElse(Stream.empty())
//                    .map(SimpleGrantedAuthority::new)
//                    .map(GrantedAuthority.class::cast)
//                    .toList();
//        };
//
//
//
//    @Bean
//    JwtAuthenticationConverter authenticationConverter(
//
//            Converter<Map<String, Object>, Collection<GrantedAuthority>> authoritiesConverter) {
//        var authenticationConverter = new JwtAuthenticationConverter();
//        authenticationConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
//            return authoritiesConverter.convert(jwt.getClaims());
//        });
//        return authenticationConverter;
//    }
//
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        log.info("configuring web security");
////        http
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/swagger-ui/**","/test").permitAll() // Public endpoints
////                )
////                .oauth2ResourceServer(oauth2 -> oauth2
////                        .jwt(jwt -> jwt.jwtAuthenticationConverter(keycloakJwtAuthenticationConverter()))
////                );
////
////        return http.build();
////    }
//@Bean
//SecurityFilterChain resourceServerSecurityFilterChain(
//        HttpSecurity http,
//        Converter<Jwt, AbstractAuthenticationToken> authenticationConverter) throws Exception {
//    http.oauth2ResourceServer(resourceServer -> {
//        resourceServer.jwt(jwtDecoder -> {
//            jwtDecoder.jwtAuthenticationConverter(authenticationConverter);
//        });
//    });
//
//    http.sessionManagement(sessions -> {
//        sessions.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }).csrf(csrf -> {
//        csrf.disable();
//    });
//
//    http.authorizeHttpRequests(requests -> {
//        requests.requestMatchers("/test2").authenticated();
//        requests.anyRequest().denyAll();
//    });
//
//    return http.build();
//}
//
////    private JwtAuthenticationConverter keycloakJwtAuthenticationConverter() {
////        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
////        // Map Keycloak's roles to Spring Security roles
////        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
////            var roles = jwt.getClaimAsStringList("roles"); // Adjust claim as per your Keycloak setup
////            log.info("roles : {}",roles);
////            return roles.stream()
////                    .map(role -> "ROLE_" + role.toUpperCase())
////                    .map(SimpleGrantedAuthority::new).collect(Collectors.toCollection(ArrayList::new))
////                   ;
////        });
////        return converter;
////    }
//}
