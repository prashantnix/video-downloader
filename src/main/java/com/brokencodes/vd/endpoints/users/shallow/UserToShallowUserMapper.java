package com.brokencodes.vd.endpoints.users.shallow;

import com.brokencodes.vd.beans.users.User;
import org.springframework.stereotype.Component;

@Component
public class UserToShallowUserMapper {

    public ShallowUser toShallowUser(User user) {
        return ShallowUser.builder()
                .id(user.getId())
                .emailId(user.getEmail())
                .firstName(user.getProfile().getFirstName())
                .lastName(user.getProfile().getLastName())
                .build();
    }
}
