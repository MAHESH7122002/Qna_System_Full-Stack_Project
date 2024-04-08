package com.maheshnallada.QNA.controller;

import com.maheshnallada.QNA.Model.User;
import com.maheshnallada.QNA.dto.UserDto;
import com.maheshnallada.QNA.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@CrossOrigin("*")
@Controller
@RequestMapping("/api/v1")
public class UserController
{

    public UserController(UserService userService)
    {
        super();
        this.userService = userService;
    }

    private final UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @GetMapping("/user/details")
    public ResponseEntity<Optional<User>> getUserDetails(Authentication authentication)
    {
        DefaultOAuth2User oauth2User = (DefaultOAuth2User) authentication.getPrincipal();
        String email = (String) oauth2User.getAttribute("email");
        logger.info("Fetching user details for email: {}", email);
        Optional<User> userDetails = userService.getUserDetailsByEmail(email);
        return ResponseEntity.ok(userDetails);
    }

    //Login Page
    @GetMapping("/login")
    public String getLoginPage()
    {
        return "login";
    }

}
