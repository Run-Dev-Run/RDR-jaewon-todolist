package com.drd.rdr_to_do_list.api.common.domain.exception;

public enum ErrorMessage {
    NOT_FOUND_USERNAME("아이디를 찾을 수 없습니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
