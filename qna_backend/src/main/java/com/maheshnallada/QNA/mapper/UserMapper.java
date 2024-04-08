package com.maheshnallada.QNA.mapper;

import com.maheshnallada.QNA.Model.Qna;
import com.maheshnallada.QNA.Model.User;
import com.maheshnallada.QNA.dto.QnaDto;
import com.maheshnallada.QNA.dto.UserDto;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapper
{
//    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static UserDto mapToUserDto(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        userDto.setSource(user.getSource());
        return userDto;
    }



    public static User mapToUser(UserDto userDto)
    {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setRole(userDto.getRole());
        user.setEmail(userDto.getEmail());
        user.setSource(userDto.getSource());


        return user;
    }
}