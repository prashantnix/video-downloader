package com.brokencodes.vd.repositories;

import com.brokencodes.vd.beans.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
