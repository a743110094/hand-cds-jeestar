package site.h4n.base.exception;

import java.io.Serializable;
import java.util.Arrays;

/**
 * H4N 无跟踪异常
 * 不打印Trace 即错误栈
 * @author Heaven96
 * @date 2024/02/26
 */
public class H4nNoTraceException extends H4nBusinessException implements Serializable {
    public H4nNoTraceException() {
    }

    public H4nNoTraceException(String message) {
        super(message, null, true, false);
    }

    public H4nNoTraceException(String message, Throwable cause) {
        super(message, cause, true, false);
    }

    public H4nNoTraceException(Throwable cause) {
        super(null, cause, true, false);
    }

    public H4nNoTraceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, true, false);
    }
}
