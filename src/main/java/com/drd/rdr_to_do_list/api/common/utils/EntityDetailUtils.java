package com.drd.rdr_to_do_list.api.common.utils;

import java.util.Objects;

import com.drd.rdr_to_do_list.api.common.annotation.EntityDetail;
import com.drd.rdr_to_do_list.api.common.exception.LogicException;
import com.drd.rdr_to_do_list.api.common.exception.CommonErrorMessage;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EntityDetailUtils {
    public static String nameForException(final Class<?> entityClass) {
        return entityDetail(entityClass).nameForException();
    }

    private static EntityDetail entityDetail(final Class<?> classType) {
        EntityDetail entityDetail = classType.getAnnotation(EntityDetail.class);
        if (Objects.isNull(entityDetail)) {
            throw new LogicException(
                CommonErrorMessage.NOT_DEFINED_ENTITY_DETAIL.message(classType.getName())
            );
        }
        return entityDetail;
    }
}
