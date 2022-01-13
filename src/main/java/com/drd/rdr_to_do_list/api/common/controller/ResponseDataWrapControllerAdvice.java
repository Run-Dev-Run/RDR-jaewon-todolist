package com.drd.rdr_to_do_list.api.common.controller;

import com.drd.rdr_to_do_list.api.common.annotation.ResponseData;
import com.drd.rdr_to_do_list.api.common.dto.CommonResponseData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@SuppressWarnings({"NullableProblems", "ConstantConditions"})
@RestControllerAdvice
public class ResponseDataWrapControllerAdvice implements ResponseBodyAdvice<Object> {
    private final ObjectMapper objectMapper;

    @Override
    public boolean supports(final MethodParameter methodParameter, final Class<? extends HttpMessageConverter<?>> aClass) {
        return Objects.nonNull(
                methodParameter.getMethodAnnotation(ResponseData.class)
        );
    }

    @Override
    public Object beforeBodyWrite(final Object returnValue, final MethodParameter methodParameter, final MediaType mediaType, final Class<? extends HttpMessageConverter<?>> aClass, final ServerHttpRequest serverHttpRequest, final ServerHttpResponse serverHttpResponse) {
        ResponseData responseData = getResponseData(methodParameter);

        applyStatusCode(responseData, serverHttpResponse);
        return wrappedResponseData(responseData, methodParameter, returnValue);
    }

    private ResponseData getResponseData(final MethodParameter methodParameter) {
        return methodParameter.getMethodAnnotation(ResponseData.class);
    }

    private void applyStatusCode(final ResponseData responseData, final ServerHttpResponse serverHttpResponse) {
        serverHttpResponse.setStatusCode(responseData.code());
    }

    @SneakyThrows
    private Object wrappedResponseData(final ResponseData responseData, final MethodParameter methodParameter, final Object returnValue) {
        CommonResponseData<Object> commonResponseData = toCommonResponseData(responseData, returnValue);
        if (isRequiredSelfTransformReturnType(methodParameter)) {
            return objectMapper.writeValueAsString(commonResponseData);
        }
        return commonResponseData;
    }

    private CommonResponseData<Object> toCommonResponseData(ResponseData responseData, Object returnValue) {
        if (responseData.messageOnly()) {
            return new CommonResponseData<>(returnValue.toString());
        }
        return new CommonResponseData<>(responseData.message(), returnValue);
    }

    private boolean isRequiredSelfTransformReturnType(final MethodParameter methodParameter) {
        return methodParameter.getMethod().getReturnType() == String.class;
    }
}
