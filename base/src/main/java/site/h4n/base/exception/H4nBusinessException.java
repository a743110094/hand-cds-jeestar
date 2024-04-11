package site.h4n.base.exception;

import java.io.Serializable;

/**
 * h4n业务异常
 *
 * @author Heaven96
 * @date 2024/02/26
 */
public class H4nBusinessException extends H4nRuntimeException implements Serializable {
    public H4nBusinessException() {
    }

    public H4nBusinessException(String message) {
        super(message);
    }

    public H4nBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public H4nBusinessException(Throwable cause) {
        super(cause);
    }

    public H4nBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
