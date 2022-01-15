package com.drd.rdr_to_do_list.api.diary.controller;

import com.drd.rdr_to_do_list.api.common.exception.entitynotfound.EntityNameForException;
import com.drd.rdr_to_do_list.api.common.exception.entitynotfound.EntityNotFoundExceptionAffix;

public class DiaryResponseMessage {
    private DiaryResponseMessage() {
    }

    public static final String SEARCH = "다이어리 리스트가 성공적으로 조회 되었습니다.";
    public static final String DETAIL = "다이어리 목록이 성공적으로 조회 되었습니다.";
    public static final String ADD = "다이어리가 성공적으로 추가 되었습니다.";
    public static final String EDIT = "다이어리 정보가 성공적으로 변경 되었습니다.";
    public static final String DELETE = "다이어리가 성공적으로 삭제 되었습니다.";

    public static final String NOT_FOUND_DIARY =
        EntityNotFoundExceptionAffix.PREFIX + EntityNameForException.DIARY + EntityNotFoundExceptionAffix.SUFFIX;

    public static final String VALID_NAME = "사용 가능한 다이어리 이름 입니다.";
    public static final String NOT_VALID_NAME = "사용할 수 없는 다이어리 이름 입니다.";
}
