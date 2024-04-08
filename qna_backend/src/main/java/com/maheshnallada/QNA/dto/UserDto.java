package com.maheshnallada.QNA.dto;


import com.maheshnallada.QNA.Model.RegistrationSource;
import com.maheshnallada.QNA.Model.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto
{
    private long userId;

    private String userName;
    private String email;
    private UserRole role;

    @Enumerated(EnumType.STRING)
    private RegistrationSource source;
}