package com.drd.rdr_to_do_list.api.diary.converter;

import org.springframework.stereotype.Component;

import com.drd.rdr_to_do_list.api.diary.dto.DiaryBundle;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryRequest;

@Component
public class DiaryBundleConverter {
    public DiaryBundle.Search toSearch(DiaryRequest.Search request) {
        return DiaryBundle.Search.builder()
            .page(request.getPage())
            .build();
    }

    public DiaryBundle.AddEdit toAdd(DiaryRequest.AddEdit request) {
        return DiaryBundle.AddEdit.builder()
                .diaryName(request.getDiaryName())
                .build();
    }

    public DiaryBundle.AddEdit toDetailEdit(DiaryRequest.AddEdit request) {
        return DiaryBundle.AddEdit.builder()
                .diaryName(request.getDiaryName())
                .build();
    }
}
