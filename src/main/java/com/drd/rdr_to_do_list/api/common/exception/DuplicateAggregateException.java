package com.drd.rdr_to_do_list.api.common.exception;

public abstract class DuplicateAggregateException extends RuntimeException {
    public DuplicateAggregateException() {
    }

    public DuplicateAggregateException(final String message) {
        super(message);
    }

    public DuplicateAggregateException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DuplicateAggregateException(final Throwable cause) {
        super(cause);
    }

    public DuplicateAggregateException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
