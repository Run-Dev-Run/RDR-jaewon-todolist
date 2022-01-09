package com.drd.rdr_to_do_list.api.diary.repository;

import com.drd.rdr_to_do_list.api.common.domain.PageBundle;
import com.drd.rdr_to_do_list.api.diary.domain.Diary;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface DiaryRepository {
    Page<Diary> findPage(PageBundle pageBundle);

    Optional<Diary> findById(long id);

    boolean existsName(String name);

    void save(Diary diary);
}
