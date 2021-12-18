package com.example.registrationLoginSecurityThymeleaf.Service;

import com.example.registrationLoginSecurityThymeleaf.Model.User;
import com.example.registrationLoginSecurityThymeleaf.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {



    User save(UserRegistrationDto registrationDto);

   // List<User> listAll();
}
