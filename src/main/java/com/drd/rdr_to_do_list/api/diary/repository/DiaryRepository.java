package com.drd.rdr_to_do_list.api.diary.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.drd.rdr_to_do_list.api.diary.domain.Diary;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryBundle;

public interface DiaryRepository {
    Page<Diary> findPage(DiaryBundle.Search bundle);

    Optional<Diary> findById(long id);

    boolean existsName(String name);

    void save(Diary diary);
}
