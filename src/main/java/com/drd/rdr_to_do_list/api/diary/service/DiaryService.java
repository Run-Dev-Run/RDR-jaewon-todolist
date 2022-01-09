package com.drd.rdr_to_do_list.api.diary.service;

import com.drd.rdr_to_do_list.api.common.domain.PageBundle;
import com.drd.rdr_to_do_list.api.common.domain.PageSize;
import com.drd.rdr_to_do_list.api.diary.converter.DiaryEntityConverter;
import com.drd.rdr_to_do_list.api.diary.domain.Diary;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryBundle;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryResponse;
import com.drd.rdr_to_do_list.api.diary.exception.DiaryNotFoundException;
import com.drd.rdr_to_do_list.api.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DiaryService {
    private final DiaryEntityConverter diaryEntityConverter;
    private final DiaryRepository diaryRepository;

    @Transactional(readOnly = true)
    public Page<DiaryResponse.ListItem> list(int pageNumber) {
        return diaryRepository.findPage(new PageBundle(PageSize.DIARY_LIST, pageNumber))
                .map(Diary::converter)
                .map(Diary.Converter::toListItem);
    }

    @Transactional
    public void add(DiaryBundle.Add bundle) {
        Diary diary = diaryEntityConverter.toEntity(bundle);
        diaryRepository.save(diary);
    }

    @Transactional
    public void edit(long id, DiaryBundle.DetailEdit bundle) {
        Diary diary = diaryRepository.findById(id).orElseThrow(DiaryNotFoundException::new);
        diary.edit(bundle);
    }

    @Transactional
    public void delete(long id) {
        Diary diary = diaryRepository.findById(id).orElseThrow(DiaryNotFoundException::new);
        diary.delete();
    }
}