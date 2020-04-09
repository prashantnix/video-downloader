package com.brokencodes.vd.beans.users;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class User {

    @Id
    private String email;

    private String password;

//    private List<Role> roles;
//
//    private UserProfile profile;

}
