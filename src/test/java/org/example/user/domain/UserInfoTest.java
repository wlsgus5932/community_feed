package org.example.user.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserInfoTest {

    @Test
    void givenNameAndProfileImage_whenCreated_thenThrowNothing() {
        //given
        String name = "abcd";
        String profileImage = "";

        //when
        //then
        assertDoesNotThrow(() -> new UserInfo(name, profileImage));
    }

    @Test
    void givenBlankNameAndProfileImage_whenCreated_thenThrowError() {
        String name = "";
        String profileImage = "";

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new UserInfo(name, profileImage));
    }
}
