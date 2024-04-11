package site.h4n.base.exception;

import java.io.Serializable;

/**
 * h4n运行时异常
 *
 * @author Heaven96
 * @date 2024/02/26
 */
public class H4nRuntimeException extends RuntimeException implements Serializable {
    public H4nRuntimeException() {
    }

    public H4nRuntimeException(String message) {
        super(message);
    }

    public H4nRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public H4nRuntimeException(Throwable cause) {
        super(cause);
    }

    public H4nRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
