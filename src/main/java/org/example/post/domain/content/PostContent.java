package org.example.post.domain.content;

// 게시글 검증을 위한 도메인
public class PostContent extends Content {
    private static final int MIN_POST_TEXT_LENGTH = 5;
    private static final int MAX_POST_TEXT_LENGTH = 500;

    public PostContent(String contentText) {
        super(contentText);
    }

    @Override
    public void checkText(String contentText) {
        if(contentText == null || contentText.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if(contentText.length() > MAX_POST_TEXT_LENGTH) {
            throw new IllegalArgumentException();
        }

        if(contentText.length() < MIN_POST_TEXT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
