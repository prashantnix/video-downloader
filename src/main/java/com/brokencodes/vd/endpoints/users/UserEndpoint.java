package com.brokencodes.vd.endpoints.users;

import com.brokencodes.vd.annotations.ValidateRequestBody;
import com.brokencodes.vd.beans.users.User;
import com.brokencodes.vd.endpoints.users.requests.UserRegistrationRequest;
import com.brokencodes.vd.endpoints.users.response.UserRegistrationResponse;
import com.brokencodes.vd.services.api.ITokenGenerator;
import com.brokencodes.vd.services.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserEndpoint {

    @Autowired
    private IUserService userService;

    @Autowired
    private ITokenGenerator tokenGenerator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/add")
    @ValidateRequestBody
    public UserRegistrationResponse addUser(@RequestBody final UserRegistrationRequest userRegistrationRequest) {
        final User user = userRegistrationRequest.toUser(tokenGenerator, passwordEncoder);
        userService.save(user);
        return UserRegistrationResponse.builder()
                .userId(user.getId())
                .build();
    }

}
