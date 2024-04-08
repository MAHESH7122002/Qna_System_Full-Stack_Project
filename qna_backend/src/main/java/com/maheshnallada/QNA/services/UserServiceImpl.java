package com.maheshnallada.QNA.services;

import com.maheshnallada.QNA.Model.User;
import com.maheshnallada.QNA.Repository.UserRepository;
import com.maheshnallada.QNA.dto.UserDto;
import com.maheshnallada.QNA.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository userRepository;
//
//
//
//    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        User user = userRepository.findByEmail(email);
//        if(user == null)
//        {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRole()));
//    }
//
//    @Override
//    public void createUserFromOAuth(DefaultOAuth2User userDetails) {
//        UserDto user = new UserDto();
//        user.setEmail(userDetails.getAttribute("email") != null ? userDetails.getAttribute("email") : userDetails.getAttribute("login"));
//        user.setUserName(user.getEmail());
//        user.setPassword("Dummy");
//        user.setRole("Admin");
//        save(user);
//    }
//
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String role) {
//        return Collections.singleton(new SimpleGrantedAuthority(role));
//    }



    @Override
    public UserDto save(UserDto userDto)
    {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        return UserMapper.mapToUserDto(savedUser);
    }



    @Override
    public Optional<User> findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }



    @Override
    public void save_user_auth(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserDetailsByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }


}
