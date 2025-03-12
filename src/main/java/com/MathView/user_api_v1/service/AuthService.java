package com.MathView.user_api_v1.service;

import com.MathView.user_api_v1.models.User;
import com.MathView.user_api_v1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent() && passwordEncoder.matches(password, user.get().getPassword());
    }

    public User register(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        User newUser = new User(username, encodedPassword);
        return userRepository.save(newUser);
    }
}
