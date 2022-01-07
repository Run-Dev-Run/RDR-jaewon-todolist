package com.drd.rdr_to_do_list.api.common.domain.exception;

public enum CommonErrorMessage {
    EXCEPTION("알 수 없는 오류가 발생 했습니다.");

    private final String message;

    CommonErrorMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
