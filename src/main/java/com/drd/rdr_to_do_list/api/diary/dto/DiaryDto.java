package com.drd.rdr_to_do_list.api.diary.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class DiaryDto {
    private final String name;
}
