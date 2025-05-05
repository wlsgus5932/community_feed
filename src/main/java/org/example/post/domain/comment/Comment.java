package org.example.post.domain.comment;

import org.example.common.domain.PositiveIntegerCounter;
import org.example.post.domain.Post;
import org.example.post.domain.content.CommentContent;
import org.example.user.domain.User;

public class Comment {
    private final Long id;
    private final User author;
    private final Post post;
    private final CommentContent content;
    private final PositiveIntegerCounter likeCount;

    public Comment(Long id, Post post, User author, CommentContent content, PositiveIntegerCounter likeCounter) {
        if(author == null) {
            throw new IllegalStateException();
        }

        if(post == null) {
            throw new IllegalStateException();
        }

        if(content == null) {
            throw new IllegalStateException();
        }

        this.id = id;
        this.post = post;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
    }

    public void like(User user) {
        if(this.author.equals(user)) {
            throw new IllegalArgumentException();
        }
        likeCount.increment();
    }

    public void unlike(User user) {
        likeCount.decrement();
    }

    public void updateComment(User user, String updatedContent) {
        if(!author.equals(user)) {
            throw new IllegalArgumentException();
        }

        content.updateContent(updatedContent);
    }
}
