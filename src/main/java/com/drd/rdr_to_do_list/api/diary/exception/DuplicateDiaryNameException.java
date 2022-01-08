package com.drd.rdr_to_do_list.api.diary.exception;

import com.drd.rdr_to_do_list.api.common.exception.DuplicateAggregateException;

public class DuplicateDiaryNameException extends DuplicateAggregateException {
    public DuplicateDiaryNameException() {
        super(DiaryErrorMessage.DUPLICATE_DIARY_NAME);
    }
}
