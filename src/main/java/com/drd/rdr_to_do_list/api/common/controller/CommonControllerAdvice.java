package com.drd.rdr_to_do_list.api.common.controller;

import com.drd.rdr_to_do_list.api.common.annotation.ResponseData;
import com.drd.rdr_to_do_list.api.common.dto.CommonResponseData;
import com.drd.rdr_to_do_list.api.common.exception.CommonErrorMessage;
import com.drd.rdr_to_do_list.api.common.exception.DisplayException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

@RequiredArgsConstructor
@SuppressWarnings("NullableProblems")
@RestControllerAdvice
public class CommonControllerAdvice implements ResponseBodyAdvice<Object> {
    private final ObjectMapper objectMapper;

    @Override
    public boolean supports(final MethodParameter methodParameter, final Class<? extends HttpMessageConverter<?>> aClass) {
        return Objects.nonNull(
                methodParameter.getMethodAnnotation(ResponseData.class)
        );
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(final Object o, final MethodParameter methodParameter, final MediaType mediaType, final Class<? extends HttpMessageConverter<?>> aClass, final ServerHttpRequest serverHttpRequest, final ServerHttpResponse serverHttpResponse) {
        ResponseData data = toResponseData(methodParameter);

        serverHttpResponse.setStatusCode(data.code());
        if (isMessageOnly(data, o)) {
            return objectMapper.writeValueAsString(
                    new CommonResponseData<>(o.toString())
            );
        }
        return new CommonResponseData<>(data.message(), o);
    }

    private ResponseData toResponseData(final MethodParameter methodParameter) {
        return methodParameter.getMethodAnnotation(ResponseData.class);
    }

    private boolean isMessageOnly(ResponseData data, Object result) {
        return data.messageOnly() && result instanceof String;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DisplayException.class)
    public CommonResponseData<Void> displayException(Exception e) {
        return new CommonResponseData<>(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public CommonResponseData<Void> other(Exception e) {
        e.printStackTrace();
        return new CommonResponseData<>(CommonErrorMessage.EXCEPTION.message());
    }
}
