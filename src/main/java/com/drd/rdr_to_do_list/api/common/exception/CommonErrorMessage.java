package com.drd.rdr_to_do_list.api.common.exception;

public enum CommonErrorMessage {
    NOT_DEFINED_ENTITY_DETAIL("[%s] @EntityDetail 정의 필요"),
    COMMON("알 수 없는 오류가 발생 했습니다.");

    private final String message;

    CommonErrorMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

    public String message(Object... args) {
        return String.format(message, args);
    }
}
