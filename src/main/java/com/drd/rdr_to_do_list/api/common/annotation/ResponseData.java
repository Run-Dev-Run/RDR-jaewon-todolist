package com.drd.rdr_to_do_list.api.common.annotation;

import org.springframework.http.HttpStatus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseData {
    HttpStatus code();

    String message() default "";

    boolean messageOnly() default false;
}
