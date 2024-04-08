package com.maheshnallada.QNA.services;

import com.maheshnallada.QNA.Model.User;
import com.maheshnallada.QNA.dto.UserDto;

import java.util.Optional;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;


public interface UserService {

//    void createUserFromOAuth(DefaultOAuth2User userDetails);

    UserDto save(UserDto userDto);




    Optional<User> findByEmail(String email);

    void save_user_auth(User user);
    Optional<User> getUserDetailsByEmail(String email);

//    UserDetails loadUserByUsername(String email);

}