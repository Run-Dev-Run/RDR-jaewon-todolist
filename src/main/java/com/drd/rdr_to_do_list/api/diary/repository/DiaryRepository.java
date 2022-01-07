package com.drd.rdr_to_do_list.api.diary.repository;

import com.drd.rdr_to_do_list.api.diary.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
