package com.maheshnallada.QNA.config;


import com.maheshnallada.QNA.Model.RegistrationSource;
import com.maheshnallada.QNA.Model.User;
import com.maheshnallada.QNA.Model.UserRole;
import com.maheshnallada.QNA.controller.UserController;
import com.maheshnallada.QNA.dto.UserDto;
import com.maheshnallada.QNA.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.maheshnallada.QNA.Model.RegistrationSource.GOOGLE;

@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final UserService userService;

    @Value("${frontend.url}")
    private String frontendUrl;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException
    {


        String source;
        String unique_id;

        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
        if ( "github".equals(oAuth2AuthenticationToken.getAuthorizedClientRegistrationId()) || "google".equals(oAuth2AuthenticationToken.getAuthorizedClientRegistrationId()) )
        {
            if("github".equals(oAuth2AuthenticationToken.getAuthorizedClientRegistrationId()))
            {
                 source = "github";
                 unique_id="id";
            }
            else {
                 source = "google";
                 unique_id="sub";
            }
            logger.info(source);



            DefaultOAuth2User principal = (DefaultOAuth2User) authentication.getPrincipal();
            Map<String, Object> attributes = principal.getAttributes();
            logger.info("Attributes from OAuth2 provider: {}", attributes);

            String email = attributes.getOrDefault("email", "").toString();
            String name = attributes.getOrDefault("name", "").toString();
            logger.info("email:"+email+"  name:"+name);
            userService.findByEmail(email)
                    .ifPresentOrElse(user -> {

                        DefaultOAuth2User newUser = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority(user.getRole().name())),
                                attributes,unique_id);
                        logger.info("newUser1:"+newUser);
                        Authentication securityAuth = new OAuth2AuthenticationToken(newUser, List.of(new SimpleGrantedAuthority(user.getRole().name())),
                                oAuth2AuthenticationToken.getAuthorizedClientRegistrationId());
                        logger.info("securityAuth:"+securityAuth);
                        SecurityContextHolder.getContext().setAuthentication(securityAuth);
                    }, () -> {


                        User user = new User();

                        user.setRole(UserRole.ROLE_USER);
                        user.setEmail(email);
                        user.setUserName(name);

                        logger.info(String.valueOf(user));
                        if(source.equals("github")){
                        user.setSource(RegistrationSource.GITHUB);}
                        else{
                            user.setSource(RegistrationSource.GOOGLE);
                        }
                        logger.info("source:"+source);
                        userService.save_user_auth(user);


                        DefaultOAuth2User newUser = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority(user.getRole().name())),
                                attributes,unique_id);
                        logger.info("newUser:"+newUser);
                        Authentication securityAuth = new OAuth2AuthenticationToken(newUser, List.of(new SimpleGrantedAuthority(user.getRole().name())),
                                oAuth2AuthenticationToken.getAuthorizedClientRegistrationId());
                        logger.info("securityAuth:"+securityAuth);
                        SecurityContextHolder.getContext().setAuthentication(securityAuth);
                    });
        }
        this.setAlwaysUseDefaultTargetUrl(true);
        this.setDefaultTargetUrl(frontendUrl);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}