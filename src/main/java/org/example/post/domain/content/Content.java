package org.example.post.domain.content;

// 게시글이나 댓글 같은 게시판 관련 검증을 위한 추상화

import org.example.post.domain.common.DatetimeInfo;

// 상속은 어디에서든 받을 수 있게 public
public abstract class Content {
    String contentText;
    DatetimeInfo datetimeInfo;

    // 자식만 접근 가능하고 외부에서 접근 못하게 protected
    protected Content(String contentText) {
        checkText(contentText);
        this.contentText = contentText;
        this.datetimeInfo = new DatetimeInfo();
    }

    public void updateContent(String updateContent) {
        checkText(updateContent);
        this.contentText = updateContent;
        this.datetimeInfo.updateEditDatetime();
    }

    // 자식만 접근 가능하고 외부에서 접근 못하게 protected
    protected abstract void checkText(String contentText);

    // get 메소드 public
    public String getContentText() {
        return contentText;
    }
}
