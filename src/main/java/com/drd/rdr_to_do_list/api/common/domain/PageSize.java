package com.drd.rdr_to_do_list.api.common.domain;

public enum PageSize {
    DIARY_LIST(15);

    private final int size;

    PageSize(final int size) {
        this.size = size;
    }

    public int size() {
        return size;
    }
}
