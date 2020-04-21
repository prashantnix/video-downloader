package com.brokencodes.vd.endpoints.users;

import com.brokencodes.vd.beans.users.User;
import com.brokencodes.vd.beans.users.UserProfile;
import com.brokencodes.vd.endpoints.users.shadow.ShadowUser;
import com.brokencodes.vd.endpoints.users.shadow.UserToShadowUserMapper;
import com.brokencodes.vd.services.api.ITokenGenerator;
import com.brokencodes.vd.services.api.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(excludeAutoConfiguration = SecurityAutoConfiguration.class)
class UserEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUserService userService;

    @MockBean
    private ITokenGenerator tokenGenerator;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserToShadowUserMapper userToShadowUserMapper;

    @Test
    void findUserShallow() throws Exception {
        User testUser = User.builder()
                .id("user")
                .profile(UserProfile.builder()
                        .firstName("user-first-name")
                        .lastName("user-last-name")
                        .email("user@test.com")
                        .build()
                )
                .email("user@test.com")
                .build();

        ShadowUser testShadowUser = ShadowUser.builder()
                .id("user")
                .emailId("user@test.com")
                .firstName("user-first-name")
                .lastName("user-last-name")
                .build();

        when(userService.findById(eq("user"))).thenReturn(testUser);
        when(userToShadowUserMapper.toShadowUser(eq(testUser))).thenReturn(testShadowUser);

        mockMvc.perform(get("/api/users/get/user/shadow"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void findUserDeep() {
    }

    @Test
    void verifyUserEmail() {
    }

    @Test
    void resendVerificationEmail() {
    }

    @Test
    void addUser() {
    }

}