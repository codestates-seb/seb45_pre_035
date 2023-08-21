package com.preproject_35.element.like.interface_like;

import java.time.LocalDateTime;

public abstract class Like {
    private long memberId;
    private LocalDateTime createdAt;

    protected Like() {}

    protected Like(long memberId) {
        this.memberId = memberId;
        this.createdAt = LocalDateTime.now();
    }

    public long getMemberId() {
        return memberId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
