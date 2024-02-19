package com.akerke.financeapp.common.aspect;

import com.akerke.financeapp.common.mapper.UserMapper;
import com.akerke.financeapp.model.dto.UserDTO;
import com.akerke.financeapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class BeforeMeAspect {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Before("execution(* com.akerke.financeapp.controller.UserController.me(..))")
    void beforeMe() {
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info(principal.toString());
        var oidcUser = (OidcUser) principal;
        var email = (String) oidcUser.getClaims().get("email");

        if (userRepository.existsByEmail(email)) {
            log.info("User with email %s already exists".formatted(email));
            return;
        }

        var preferredUsername =(String) oidcUser.getClaims().get("preferred_username");
        var givenName = (String) oidcUser.getClaims().get("given_name");
        var familyName = (String) oidcUser.getClaims().get("family_name");
        var user = userMapper.toModel(new UserDTO(givenName, familyName, preferredUsername,email));
        log.info("Saving user %s".formatted(email));
        userRepository.save(user);
    }

}
