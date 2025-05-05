package org.example.user.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private final UserInfo userInfo = new UserInfo("abcd", "localhost");
    private User user1;
    private User user2;

    @BeforeEach
    void init () {
        user1 = new User(1L, userInfo);
        user2 = new User(2L, userInfo);
    }

    @Test
    void givenToUser_whenEquals_thenReturnFalse() {
        //when
        boolean isEqual = user1.equals(user2);

        //then
        assertFalse(isEqual);
    }

    @Test
    void givenTwoSameUserId_whenEquals_thenReturnTrue() {
        //given
        User sameUser = new User(1L, userInfo);

        //when
        boolean isEqual = user1.equals(sameUser);

        //then
        assertTrue(isEqual);
    }

    @Test
    void givenTwoUser_whenHashCode_thenReturnNotEqual() {
        //given
        int hashCode1 = user1.hashCode();
        int hashCode2 = user2.hashCode();

        //when
        //then
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void givenTwoSameUserId_whenHashCode_thenEqual() {
        //given
        User sameUser = new User(1L, userInfo);
        int hashCode1 = user1.hashCode();
        int sameUserHashCode = sameUser.hashCode();

        //when
        //then
        assertEquals(hashCode1, sameUserHashCode);
    }

    @Test
    void givenTwoUser_whenUser1FollowUser2_thenIncreaseUserCount() {
        //when
        user1.follow(user2);

        //then
        assertEquals(1, user1.followingCount());
        assertEquals(0, user1.followerCount());

        assertEquals(0, user2.followingCount());
        assertEquals(1, user2.followerCount());
    }
}
