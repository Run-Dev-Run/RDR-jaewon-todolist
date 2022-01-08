package com.drd.rdr_to_do_list.api.diary.exception;

import com.drd.rdr_to_do_list.api.common.exception.WithResponseException;
import org.springframework.http.HttpStatus;

public class DuplicateDiaryNameException extends WithResponseException {
    public DuplicateDiaryNameException() {
        super(HttpStatus.CONFLICT, DiaryErrorMessage.DUPLICATE_DIARY_NAME);
    }
}
