package com.drd.rdr_to_do_list.api.diary.controller;

public class DiaryResponseMessage {
    private DiaryResponseMessage() {
    }

    public static final String PAGE = "다이어리가 성공적으로 조회 되었습니다.";
    public static final String ADD = "다이어리가 성공적으로 추가 되었습니다.";
    public static final String EDIT = "다이어리 정보가 성공적으로 변경 되었습니다.";
    public static final String DELETE = "다이어리가 성공적으로 삭제 되었습니다.";

    public static final String VALIDATE_NAME = "다이어리 이름의 사용 가능 여부가 성공적으로 조회 되었습니다.";
}
