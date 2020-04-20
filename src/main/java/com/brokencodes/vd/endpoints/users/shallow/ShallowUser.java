package com.brokencodes.vd.endpoints.users.shallow;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShallowUser {

    private String id;

    private String emailId;

    private String firstName;

    private String lastName;

}
