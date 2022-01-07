package com.drd.rdr_to_do_list.api.common.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponseData<T> extends ResponseData {
    private final String message;
    private final T data;

    public CommonResponseData(final String message, final T data) {
        this.message = message;
        this.data = data;
    }

    public CommonResponseData(final String message) {
        this(message, null);
    }
}
