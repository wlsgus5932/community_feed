package org.example.post.domain.content;

public class CommentContent extends Content {

    private static final long MAX_COMMENT_TEXT = 100;

    public CommentContent(String contentText) {
        super(contentText);
    }

    @Override
    protected void checkText(String contentText) {
        if(contentText == null || contentText.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if(contentText.length() > MAX_COMMENT_TEXT) {
            throw new IllegalArgumentException();
        }
    }
}
