package com.drd.rdr_to_do_list.api.common.exception.entitynotfound;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EntityNotFoundExceptionAffix {
    public static final String PREFIX = "존재하지 않는 ";
    public static final String SUFFIX = " 입니다.";
}
