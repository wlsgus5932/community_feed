package org.example.user.application;

import org.example.user.application.dto.CreateUserRequestDto;
import org.example.user.application.interfaces.UserRepository;
import org.example.user.domain.User;
import org.example.user.domain.UserInfo;
import org.example.user.repository.FakeUserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {
    private final UserRepository userRepository = new FakeUserRepository();
    private final UserService userService = new UserService(userRepository);

    @Test
    void givenUserInfoDtd_whenCreatedUser_thenCanFindUser() {
        //given
        CreateUserRequestDto createUserRequestDto = new CreateUserRequestDto("test", "local");

        //when
        User savedUser = userService.createUser(createUserRequestDto);

        //then
        User foundUser = userService.getUser(savedUser.getId());
        UserInfo foundUserInfo = foundUser.getUserInfo();

        assertEquals(savedUser.getId(), foundUser.getId());
        assertEquals("test", foundUserInfo.getName());
    }

}
