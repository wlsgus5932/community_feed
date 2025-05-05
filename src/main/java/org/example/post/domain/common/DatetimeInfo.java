package org.example.post.domain.common;

import java.time.LocalDateTime;

public class DatetimeInfo {
    private Boolean isEdited;
    private LocalDateTime dateTime;

    public DatetimeInfo() {
        this.isEdited = false;
        this.dateTime = LocalDateTime.now();
    }

    public void updateEditDatetime() {
        this.isEdited = true;
        this.dateTime = LocalDateTime.now();
    }

    public Boolean getEdited() {
        return isEdited;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
