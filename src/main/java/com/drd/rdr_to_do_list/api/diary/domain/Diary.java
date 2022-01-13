package com.drd.rdr_to_do_list.api.diary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.drd.rdr_to_do_list.api.common.annotation.EntityDetail;
import com.drd.rdr_to_do_list.api.common.domain.entity.AbstractEntity;
import com.drd.rdr_to_do_list.api.common.domain.entity.EntityConverter;
import com.drd.rdr_to_do_list.api.common.exception.entitynotfound.EntityNameForException;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryBundle;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryResponse;

import lombok.Builder;

@Table(name = "T_DIARY",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "DIARY_UNIQUE_NAME", columnNames = { "DIARY_NAME", "DELETED_DATE" }
            )
        },
        indexes = {
            @Index(name = "DIARY_INDEX_NAME", columnList = "DIARY_NAME")
        }
)
@EntityDetail(nameForException = EntityNameForException.DIARY)
@Entity
public class Diary extends AbstractEntity<Diary.Converter> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIARY_ID", nullable = false, updatable = false)
    private long id;

    @Column(name = "DIARY_NAME", nullable = false, length = 50)
    private String name;

    protected Diary() {
    }

    @Builder
    public Diary(final String name) {
        this.name = name;
    }

    public void edit(DiaryBundle.AddEdit bundle) {
        this.name = bundle.getDiaryName();
    }

    public void delete() {
        // TODO :: 모든 TODO 리스트에서도 delete 처리 해줘야 함
        super.delete();
    }

    @Override
    public Converter converter() {
        return new Converter(this);
    }

    public static class Converter implements EntityConverter {
        private final Diary diary;

        private Converter(final Diary diary) {
            this.diary = diary;
        }

        public DiaryResponse.ListItem toListItem() {
            return DiaryResponse.ListItem.builder()
                    .id(diary.id)
                    .diaryName(diary.name)
                    .createdTime(diary.createdDate)
                    .build();
        }

        public DiaryResponse.Detail toDetail() {
            return DiaryResponse.Detail.builder()
                .id(diary.id)
                .diaryName(diary.name)
                .build();
        }
    }
}
