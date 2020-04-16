package com.brokencodes.vd.endpoints.users.requests;

import com.brokencodes.vd.beans.downloader.configurations.DownloadProfile;
import com.brokencodes.vd.beans.downloader.configurations.ProxyConfiguration;
import com.brokencodes.vd.beans.downloader.configurations.UserConfiguration;
import com.brokencodes.vd.beans.users.Role;
import com.brokencodes.vd.beans.users.User;
import com.brokencodes.vd.beans.users.UserProfile;
import com.brokencodes.vd.endpoints.base.IValidateRequest;
import com.brokencodes.vd.endpoints.base.Validation;
import com.brokencodes.vd.services.api.ITokenGenerator;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class UserRegistrationRequest implements IValidateRequest {

    private static final String ROLE_NEW_USER = "VD_ROLE_NEW_USER";

    private String email;

    private String password;

    private String confirmationPassword;

    @Override
    public Validation validate() {

        // Email Validations
        if (StringUtils.isBlank(email)) {
            return new Validation("Provide an email id");
        }
        if (!EmailValidator.getInstance().isValid(email)) {
            return new Validation("Email id is not valid");
        }

        // Password Validations
        if (StringUtils.isBlank(password)) {
            return new Validation("Provide a password");
        }
        if (password.length() < 6) {
            return new Validation("Password must be at least 6 characters long");
        }
        // TODO:  Password policy validation
        if (!password.equals(confirmationPassword)) {
            return new Validation("Passwords do not match");
        }
        return null;
    }

    public User toUser(final ITokenGenerator tokenGenerator, final PasswordEncoder passwordEncoder) {
        String userId = tokenGenerator.generateTokenFromString(email);
        return User.builder()
                .id(userId)
                .email(email)
                .password(passwordEncoder.encode(password))
                .roles(
                        new HashSet<>(Collections.singletonList(
                                Role.builder()
                                        .name(ROLE_NEW_USER)
                                        .build()
                        ))
                )
                .profile(
                        UserProfile.builder()
                                .id(userId)
                                .email(email)
                                .configurations(
                                        UserConfiguration.builder()
                                                .proxyConfiguration(
                                                        ProxyConfiguration.builder()
                                                                .id(userId)
                                                                .build()
                                                )
                                                .downloadProfiles(
                                                        Stream.of(
                                                                DownloadProfile.builder()
                                                                        .id(userId)
                                                                        .profileName("DEFAULT")
                                                                        .isMultiThreadingEnabled(false)
                                                                        .shouldAddIndexToDownloadedFiles(false)
                                                                        .maxParallelDownloads(1)
                                                                        .build()
                                                        ).collect(Collectors.toSet())
                                                )
                                                .shouldStoreDownloadsInIndividualDirectory(true)
                                                .build()
                                )
                                .build()
                )
                .build();
    }

}
