package org.example.user.application;

import org.example.user.application.dto.CreateUserRequestDto;
import org.example.user.application.dto.FollowUserRequestDto;
import org.example.user.application.interfaces.UserRelationalRepository;
import org.example.user.application.interfaces.UserRepository;
import org.example.user.domain.User;
import org.example.user.repository.FakeUserRelationalRepository;
import org.example.user.repository.FakeUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserRelationServiceTest {
    private final UserRepository userRepository = new FakeUserRepository();
    private final UserService userService = new UserService(userRepository);
    private final UserRelationalRepository userRelationalRepository = new FakeUserRelationalRepository();
    private final UserRelationService userRelationService = new UserRelationService(userService, userRelationalRepository);

    private User user1;
    private User user2;

    private FollowUserRequestDto followUserRequestDto;

    @BeforeEach
    void init() {
        CreateUserRequestDto createUserRequestDto = new CreateUserRequestDto("test", "local");
        this.user1 = userService.createUser(createUserRequestDto);
        this.user2 = userService.createUser(createUserRequestDto);

        this.followUserRequestDto = new FollowUserRequestDto(user1.getId(), user2.getId());
    }

    @Test
    void givenCreateTwoUser_whenFollow_thenUserFollowSaved() {
        //when
        userRelationService.follow(followUserRequestDto);

        //then
        assertEquals(1, user1.followingCount());
        assertEquals(1, user2.followerCount());
    }

    @Test
    void givenCreateTwoUserFollowed_whenFollow_thenUserThrowError() {
        //given
        userRelationService.follow(followUserRequestDto);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> userRelationService.follow(followUserRequestDto));
    }
}
