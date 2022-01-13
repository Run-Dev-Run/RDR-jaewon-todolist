package com.drd.rdr_to_do_list.api.common.exception.entitynotfound;

import com.drd.rdr_to_do_list.api.common.utils.EntityDetailUtils;

public class EntityNotFoundException extends RuntimeException {
    private EntityNotFoundException(String message) {
        super(message);
    }

    public static EntityNotFoundException ofEntityName(String entityName) {
        return new EntityNotFoundException(
            EntityNotFoundExceptionAffix.PREFIX + entityName + EntityNotFoundExceptionAffix.SUFFIX);
    }

    public static EntityNotFoundException fromEntityClass(Class<?> entityClass) {
        return ofEntityName(EntityDetailUtils.nameForException(entityClass));
    }
}
