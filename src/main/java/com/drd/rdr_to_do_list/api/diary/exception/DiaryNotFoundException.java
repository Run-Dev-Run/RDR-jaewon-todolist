package com.drd.rdr_to_do_list.api.diary.exception;

import com.drd.rdr_to_do_list.api.common.exception.NotFoundException;

public class DiaryNotFoundException extends NotFoundException {
    public DiaryNotFoundException() {
        super(DiaryErrorMessage.DIARY_NOT_FOUND);
    }
}
