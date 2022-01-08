package com.drd.rdr_to_do_list.api.common.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("페이지 공통 응답 DTO")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PageResponse<E> {
    @ApiModelProperty(value = "List Item", dataType = "List", required = true)
    private final List<E> elements;
    @ApiModelProperty(value = "현재 페이지", dataType = "Number", required = true)
    private final int currentPage;
    @ApiModelProperty(value = "총 페이지 수", dataType = "Number", required = true)
    private final int totalPageSize;

    public PageResponse(final List<E> elements, final int currentPage, final int totalPageSize) {
        this.elements = elements;
        this.currentPage = currentPage;
        this.totalPageSize = totalPageSize;
    }
}
