package com.brokencodes.vd.services.impl;

import com.brokencodes.vd.beans.users.User;
import com.brokencodes.vd.repositories.UserRepository;
import com.brokencodes.vd.services.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(
                        existingUser -> {
                            throw new IllegalArgumentException("User with given email id already exists");
                        }
                );
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User with given email id does not not exist"));
        return userRepository.save(user);
    }

    @Override
    public User findById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException(MessageFormat.format("User with user id: {0} was not found", userId)));
    }

    @Override
    public User findByEmailId(String emailId) {
        return userRepository.findByEmail(emailId)
                .orElseThrow(() -> new UsernameNotFoundException(MessageFormat.format("User with email id: {0} was not found", emailId)));
    }

}
