package com.drd.rdr_to_do_list.api.diary.service;

import com.drd.rdr_to_do_list.api.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DiaryValidateService {
    private final DiaryRepository diaryRepository;

    public boolean existsName(String name) {
        return diaryRepository.existsName(name);
    }
}
