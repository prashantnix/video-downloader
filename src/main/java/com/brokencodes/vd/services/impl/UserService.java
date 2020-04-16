package com.brokencodes.vd.services.impl;

import com.brokencodes.vd.beans.users.User;
import com.brokencodes.vd.repositories.UserRepository;
import com.brokencodes.vd.services.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
