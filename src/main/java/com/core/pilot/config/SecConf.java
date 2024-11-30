package com.core.pilot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Configuration
@Slf4j
@EnableWebSecurity
public class SecConf {
//    @Bean
//    AuthoritiesConverter realmRolesAuthoritiesConverter() {
//        log.info("configuring realm roles authority Convertor");
//        return claims -> {
//            log.info("claims ============> {}", claims);
//            var realmAccess = Optional.ofNullable((Map<String, Object>) claims.get("realm_access"));
//            var roles = realmAccess.flatMap(map -> Optional.ofNullable((List<String>) map.get("roles")));
//            return roles.map(List::stream)
//                    .orElse(Stream.empty())
//                    .map(SimpleGrantedAuthority::new)
//                    .map(GrantedAuthority.class::cast)
//                    .toList();
//        };
//    }

//    @Bean
//    JwtAuthenticationConverter authenticationConverter(
//            Converter<Map<String, Object>, Collection<GrantedAuthority>> authoritiesConverter) {
//        log.info("configuring authenticationConverter");
//        var authenticationConverter = new JwtAuthenticationConverter();
//        authenticationConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
//            log.info("jwt claims===============> {}", jwt.getClaims());
//            log.info("jwt headers===============> {}", jwt.getHeaders());
//            return authoritiesConverter.convert(jwt.getClaims());
//        });
//        return authenticationConverter;
//    }

//    @Bean
//    SecurityFilterChain resourceServerSecurityFilterChain(
//            HttpSecurity http,
//            Converter<Jwt, AbstractAuthenticationToken> authenticationConverter) throws Exception {
//        log.info("configuring resourceServerSecurityFilterChain ");
//        http.oauth2ResourceServer(resourceServer -> {
//            resourceServer.jwt(jwtDecoder -> {
//                jwtDecoder.jwtAuthenticationConverter(authenticationConverter);
//            });
//        });
//
//        http.sessionManagement(sessions -> {
//            sessions.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        }).csrf(csrf -> {
//            csrf.disable();
//        });
//
//        http.authorizeHttpRequests(requests -> {
//            requests.requestMatchers("/test3").authenticated();
//            requests.anyRequest().permitAll();
//        });
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info("configuring security filter chain");
        http
                // CSRF configuration
                .csrf(csrf -> csrf.disable())

                // Authorization rules
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll() // Allow public APIs
                        .anyRequest().authenticated()             // Secure all other APIs
                )

                // JWT configuration (new approach)
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(jwtAuthenticationConverter()) // Optional custom converter
                        )
                );

        return http.build();
    }

    // Custom JWT Authentication Converter (Optional)
    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        log.info("configuring jwtAuthenticationConverter");
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        // Customize to extract roles or scopes if needed
        return converter;
    }

}
