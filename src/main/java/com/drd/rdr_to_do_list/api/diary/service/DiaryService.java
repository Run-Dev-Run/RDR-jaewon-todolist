package com.drd.rdr_to_do_list.api.diary.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drd.rdr_to_do_list.api.common.exception.entitynotfound.EntityNotFoundException;
import com.drd.rdr_to_do_list.api.diary.converter.DiaryEntityConverter;
import com.drd.rdr_to_do_list.api.diary.domain.Diary;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryBundle;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryResponse;
import com.drd.rdr_to_do_list.api.diary.repository.DiaryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DiaryService {
    private final DiaryEntityConverter diaryEntityConverter;
    private final DiaryRepository diaryRepository;

    @Transactional(readOnly = true)
    public Page<DiaryResponse.ListItem> list(DiaryBundle.Search bundle) {
        return diaryRepository.findPage(bundle)
                              .map(Diary::converter)
                              .map(Diary.Converter::toListItem);
    }

    @Transactional
    public void add(DiaryBundle.AddEdit bundle) {
        Diary diary = diaryEntityConverter.toDiary(bundle);
        diaryRepository.save(diary);
    }

    @Transactional(readOnly = true)
    public DiaryResponse.Detail get(long id) {
        return diaryRepository.findById(id)
                              .map(Diary::converter)
                              .map(Diary.Converter::toDetail)
                              .orElseThrow(() -> EntityNotFoundException.fromEntityClass(Diary.class));
    }

    @Transactional
    public void edit(long id, DiaryBundle.AddEdit bundle) {
        Diary diary = diaryRepository.findById(id)
                                     .orElseThrow(() -> EntityNotFoundException.fromEntityClass(Diary.class));
        diary.edit(bundle);
    }

    @Transactional
    public void delete(long id) {
        Diary diary = diaryRepository.findById(id)
                                     .orElseThrow(() -> EntityNotFoundException.fromEntityClass(Diary.class));
        diary.delete();
    }
}