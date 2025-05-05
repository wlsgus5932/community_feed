package org.example.user.repository;

import org.example.user.application.interfaces.UserRelationalRepository;
import org.example.user.domain.User;

public class FakeUserRelationalRepository implements UserRelationalRepository {
    @Override
    public boolean isAlreadyFollow(User user, User targetUser) {
        return false;
    }

    @Override
    public void save(User user, User targetUser) {

    }

    @Override
    public void delete(User user, User targetUser) {

    }
}
