package com.drd.rdr_to_do_list.api.diary.repository;

import com.drd.rdr_to_do_list.api.common.domain.PageBundle;
import com.drd.rdr_to_do_list.api.diary.domain.Diary;
import org.springframework.data.domain.Page;

public interface QDiaryRepository {
    Page<Diary> findPage(PageBundle pageBundle);

    boolean existsName(String name);
}
