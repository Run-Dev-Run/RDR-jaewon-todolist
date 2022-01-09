package com.drd.rdr_to_do_list.api.diary.converter;

import com.drd.rdr_to_do_list.api.diary.dto.DiaryBundle;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryRequest;
import org.springframework.stereotype.Component;

@Component
public class DiaryBundleConverter {
    public DiaryBundle.Add toAdd(DiaryRequest.AddEdit request) {
        return DiaryBundle.Add.builder()
                .name(request.getName())
                .build();
    }

    public DiaryBundle.DetailEdit toDetailEdit(DiaryRequest.AddEdit request) {
        return DiaryBundle.DetailEdit.builder()
                .name(request.getName())
                .build();
    }
}
