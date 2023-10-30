package com.viachaslausviatski.pet_project.services;

import com.viachaslausviatski.pet_project.entity.User;
import com.viachaslausviatski.pet_project.entity.emums.Role;
import com.viachaslausviatski.pet_project.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user){
        String email = user.getEmail();
        if (email == null) {
            log.error("Email is null for user: {}", user);
            return false; // or throw an exception
        }
        if(userRepository.findByEmail(email)!= null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new User with email:{}",email);
        userRepository.save(user);
        return true;
    }
}
