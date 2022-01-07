package com.drd.rdr_to_do_list.api.diary.domain;

import com.drd.rdr_to_do_list.api.common.domain.entity.AbstractEntity;
import com.drd.rdr_to_do_list.api.common.domain.entity.EntityConverter;
import lombok.Builder;

import javax.persistence.*;

@Table(name = "T_DIARY")
@Entity
public class Diary extends AbstractEntity<Diary.Converter> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIARY_ID", nullable = false, updatable = false)
    private long id;

    @Column(name = "DIARY_NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "DIARY_DELETED", nullable = false)
    private boolean deleted; // Base Entity로

    protected Diary() {
    }

    @Builder
    public Diary(final String name) {
        this.name = name;
        this.deleted = false;
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
    }
}
