package com.drd.rdr_to_do_list.api.diary.service;

import com.drd.rdr_to_do_list.api.diary.domain.Diary;
import com.drd.rdr_to_do_list.api.diary.repository.DiaryRepository;
import com.drd.rdr_to_do_list.api.diary.repository.QDiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;
    private final QDiaryRepository qDiaryRepository;

    @Transactional
    public void add(String name) {
        Diary diary = Diary.builder()
                .name(name)
                .build();

        diaryRepository.save(diary);
    }
}
