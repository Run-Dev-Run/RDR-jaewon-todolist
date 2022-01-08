package com.drd.rdr_to_do_list.api.diary.service;

import com.drd.rdr_to_do_list.api.common.domain.PageBundle;
import com.drd.rdr_to_do_list.api.common.domain.PageSize;
import com.drd.rdr_to_do_list.api.diary.domain.Diary;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryResponse;
import com.drd.rdr_to_do_list.api.diary.exception.DuplicateDiaryNameException;
import com.drd.rdr_to_do_list.api.diary.repository.DiaryRepository;
import com.drd.rdr_to_do_list.api.diary.repository.QDiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;
    private final QDiaryRepository qDiaryRepository;

    @Transactional(readOnly = true)
    public Page<DiaryResponse.ListItem> list(int pageNumber) {
        return qDiaryRepository.findPage(new PageBundle(PageSize.DIARY_LIST, pageNumber))
                .map(Diary::converter)
                .map(Diary.Converter::toListItem);
    }

    @Transactional
    public void add(String name) {
        if (qDiaryRepository.existsName(name)) {
            throw new DuplicateDiaryNameException();
        }
        Diary diary = Diary.builder()
                .name(name)
                .build();

        diaryRepository.save(diary);
    }
}