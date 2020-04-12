package com.brokencodes.vd.beans.users;

import com.brokencodes.vd.beans.downloader.configurations.UserConfiguration;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class UserProfile {

    @Id
    private String id;

    private String email;

    private String firstName;

    private String lastName;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @JoinColumn(name = "id")
    @MapsId
    private UserConfiguration configurations;

}
