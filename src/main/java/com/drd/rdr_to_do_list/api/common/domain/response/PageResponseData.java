package com.drd.rdr_to_do_list.api.common.domain.response;

import com.drd.rdr_to_do_list.api.common.dto.PageResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ApiModel(value = "페이지 요청에 대한 응답", parent = AbstractResponseData.class)
public class PageResponseData<E> extends AbstractResponseData {
    @ApiModelProperty(value = "Page Response", dataType = "Object", example = "{ elements : [ {Object}, {Object} ], currentPage : 0, totalPageSize : 1 }", required = true)
    private final PageResponse<E> data;

    public PageResponseData(final String message, final PageResponse<E> data) {
        super(message);
        this.data = data;
    }

    public static <E> PageResponseData<E> fromPage(final String message, Page<E> page) {
        PageResponse<E> pageResponse = new PageResponse<>(page.getContent(), page.getNumber(), page.getTotalPages());
        return new PageResponseData<>(message, pageResponse);
    }

    @Override
    public ResponseEntity<PageResponseData<E>> newResponseEntity(final HttpStatus status) {
        return new ResponseEntity<>(this, status);
    }
}
