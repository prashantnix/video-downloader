package com.brokencodes.vd.services.api;

import com.brokencodes.vd.beans.users.User;

public interface IUserService {

    User save(User user);

    User updateUser(User user);

    User findById(String userId);

    User findByEmailId(String emailId);
}
