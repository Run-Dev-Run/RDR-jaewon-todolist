package com.drd.rdr_to_do_list.api.common.domain.entity;

public interface EntityBase<C extends EntityConverter> {
    C converter();
}
