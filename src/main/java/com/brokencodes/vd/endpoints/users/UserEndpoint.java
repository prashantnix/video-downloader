package com.brokencodes.vd.endpoints.users;

import com.brokencodes.vd.annotations.ValidateRequestBody;
import com.brokencodes.vd.beans.users.User;
import com.brokencodes.vd.endpoints.users.requests.*;
import com.brokencodes.vd.endpoints.users.response.UserEmailVerificationResendResponse;
import com.brokencodes.vd.endpoints.users.response.UserEmailVerificationResponse;
import com.brokencodes.vd.endpoints.users.response.UserJwtTokenResponse;
import com.brokencodes.vd.endpoints.users.response.UserRegistrationResponse;
import com.brokencodes.vd.endpoints.users.shadow.ShadowUser;
import com.brokencodes.vd.endpoints.users.shadow.UserToShadowUserMapper;
import com.brokencodes.vd.events.SendEmailVerificationEmailEvent;
import com.brokencodes.vd.services.api.ITokenGenerator;
import com.brokencodes.vd.services.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/users")
public class UserEndpoint {

    @Value("${vd.time-outs.email-verification-token}")
    private String emailVerificationTimeout;

    @Autowired
    private IUserService userService;

    @Autowired
    private ITokenGenerator tokenGenerator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserToShadowUserMapper userToShadowUserMapper;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping({
            "/protected/get/{user-id}",
            "/protected/get/{user-id}/shadow"
    })
    public ShadowUser findUserShallow(@PathVariable("user-id") final String userId) {
        return userToShadowUserMapper.toShadowUser(userService.findById(userId));
    }

    @GetMapping("/protected/get/{user-id}/deep")
    public User findUserDeep(@PathVariable("user-id") final String userId) {
        return userService.findById(userId);
    }

//    @PostMapping("/login")
//    @ValidateRequestBody
//    public UserJwtTokenResponse authenticateUser(
//            @RequestBody final UserIdentificationWithEmailAndPasswordRequest loginRequest) {
//
//        return null;
//    }

    @PostMapping("/verify-email")
    @ValidateRequestBody
    public UserEmailVerificationResponse verifyUserEmail(
            @RequestBody final UserIdentificationWithEmailAndTokenRequest userEmailVerificationRequest) {
        User userToVerify = userService.findByEmailId(userEmailVerificationRequest.getEmail());
        if (userToVerify.getAccountVerificationToken().getExpiresOn().isAfter(LocalDateTime.now())
                && userToVerify.getAccountVerificationToken().getToken().equals(userEmailVerificationRequest.getToken())) {
            userToVerify.setAccountVerificationToken(null);
            userToVerify.setEnabled(true);
            userToVerify.setAccountVerified(true);
            userService.updateUser(userToVerify);
            return UserEmailVerificationResponse.builder()
                    .message("Your account has now been activated")
                    .build();
        }
        return UserEmailVerificationResponse.builder()
                .message("Provided token has either expired or is not valid")
                .build();
    }

    @PostMapping("/verify-email/resend")
    @ValidateRequestBody
    public UserEmailVerificationResendResponse resendVerificationEmail(
            @RequestBody final UserIdentificationWithEmailRequest userEmailVerificationResendRequest) {
        User existingUserByEmailId = userService.findByEmailId(userEmailVerificationResendRequest.getEmail());
        existingUserByEmailId.setAccountVerificationToken(tokenGenerator.generateStoredTokenFromString(
                userEmailVerificationResendRequest.getEmail(),
                emailVerificationTimeout));

        userService.updateUser(existingUserByEmailId);

        publisher.publishEvent(new SendEmailVerificationEmailEvent(existingUserByEmailId));

        return UserEmailVerificationResendResponse.builder()
                .message("A new verification code has been successfully generated and sent to your email id. This code is only valid for 24 hours")
                .build();
    }

    @PostMapping("/add")
    @ValidateRequestBody
    public UserRegistrationResponse addUser(@RequestBody final UserRegistrationRequest userRegistrationRequest) {
        final User user = userRegistrationRequest.toUser(tokenGenerator, passwordEncoder, emailVerificationTimeout);
        userService.save(user);

        publisher.publishEvent(new SendEmailVerificationEmailEvent(user));

        return UserRegistrationResponse.builder()
                .userId(user.getId())
                .build();
    }

}
