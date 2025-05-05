package org.example.user.domain;

import org.example.common.domain.PositiveIntegerCounter;

import java.util.Objects;

public class User {

    private final Long id;
    private final UserInfo userInfo;
    private final PositiveIntegerCounter followingCounter;
    private final PositiveIntegerCounter followerCounter;

    public User(Long id, UserInfo userInfo) {
        if(userInfo == null) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.userInfo = userInfo;
        this.followingCounter = new PositiveIntegerCounter();
        this.followerCounter = new PositiveIntegerCounter();
    }

    public void follow(User targetUser) {
        if(this.equals(targetUser)) {
            throw new IllegalArgumentException();
        }

        followingCounter.increment();
        targetUser.increaseFollowerCounter();
    }

    public void unfollow(User targetUser) {
        if(this.equals(targetUser)) {
            throw new IllegalArgumentException();
        }

        followingCounter.decrement();
        targetUser.decreaseFollowerCounter();
    }

    private void increaseFollowerCounter() {
        followerCounter.increment();
    }

    private void decreaseFollowerCounter() {
        followerCounter.decrement();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public int followerCount() {
        return followerCounter.getCount();
    }

    public int followingCount() {
        return followingCounter.getCount();
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}
