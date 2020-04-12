package com.brokencodes.vd.beans.users;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Role {

    @Id
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> userSet;

}

