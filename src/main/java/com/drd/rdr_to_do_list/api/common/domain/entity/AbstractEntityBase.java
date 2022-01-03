package com.drd.rdr_to_do_list.api.common.domain.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AbstractEntityBase<C extends EntityConverter> implements EntityBase<C> {
    @CreatedDate
    @Column(name = "CREATE_DATE", nullable = false)
    protected LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "MODIFIED_DATE", nullable = false)
    protected LocalDateTime modifiedDate;

    protected AbstractEntityBase() {
    }
}
