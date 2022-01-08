package com.drd.rdr_to_do_list.api.common.exception;

public abstract class DisplayException extends RuntimeException {
    public DisplayException() {
    }

    public DisplayException(final String message) {
        super(message);
    }

    public DisplayException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DisplayException(final Throwable cause) {
        super(cause);
    }

    public DisplayException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
