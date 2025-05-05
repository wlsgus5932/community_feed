package org.example.user.application;

import org.example.user.application.dto.FollowUserRequestDto;
import org.example.user.application.interfaces.UserRelationalRepository;
import org.example.user.domain.User;

public class UserRelationService {

    private final UserService userService;
    private final UserRelationalRepository userRelationalRepository;

    public UserRelationService(UserService userService, UserRelationalRepository userRelationalRepository) {
        this.userService = userService;
        this.userRelationalRepository = userRelationalRepository;
    }

    public void follow(FollowUserRequestDto dto) {
        User user = userService.getUser(dto.userId());
        User targetUser = userService.getUser(dto.targetUserId());

        if(userRelationalRepository.isAlreadyFollow(user, targetUser)) {
            throw new IllegalArgumentException();
        }

        user.follow(targetUser);
        userRelationalRepository.save(user, targetUser);
    }

    public void unfollow(FollowUserRequestDto dto) {
        User user = userService.getUser(dto.userId());
        User targetUser = userService.getUser(dto.targetUserId());

        if(!userRelationalRepository.isAlreadyFollow(user, targetUser)) {
            throw new IllegalArgumentException();
        }

        user.unfollow(targetUser);
        userRelationalRepository.delete(user, targetUser);
    }

}
