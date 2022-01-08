package com.drd.rdr_to_do_list.api.common.domain.entity;

import com.drd.rdr_to_do_list.api.common.annotation.ColumnComment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AbstractEntity<C extends EntityConverter> implements EntityBase<C> {
    @CreatedDate
    @Column(name = "CREATE_DATE", nullable = false)
    protected LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "MODIFIED_DATE", nullable = false)
    protected LocalDateTime modifiedDate;

    @ColumnComment("Soft Delete Flag")
    @Column(name = "DELETED", nullable = false)
    protected boolean deleted;

    @ColumnComment("Soft Delete Date")
    @Column(name = "DELETED_DATE")
    protected LocalDateTime deleteDate;

    protected AbstractEntity() {
        this.deleted = false;
        this.deleteDate = null;
    }

    protected void delete() {
        this.deleted = true;
        this.deleteDate = LocalDateTime.now();
    }
}
