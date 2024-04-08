package com.maheshnallada.QNA.Repository;

import com.maheshnallada.QNA.Model.User;
import com.maheshnallada.QNA.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
    Optional<User> findByEmail(String email);



}
