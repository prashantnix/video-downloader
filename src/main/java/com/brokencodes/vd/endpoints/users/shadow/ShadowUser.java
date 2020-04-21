package com.brokencodes.vd.endpoints.users.shadow;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShadowUser {

    private String id;

    private String emailId;

    private String firstName;

    private String lastName;

}
