package com.brokencodes.vd.endpoints.users.shadow;

import com.brokencodes.vd.beans.users.User;
import org.springframework.stereotype.Component;

@Component
public class UserToShadowUserMapper {

    public ShadowUser toShadowUser(User user) {
        return ShadowUser.builder()
                .id(user.getId())
                .emailId(user.getEmail())
                .firstName(user.getProfile().getFirstName())
                .lastName(user.getProfile().getLastName())
                .build();
    }
}
