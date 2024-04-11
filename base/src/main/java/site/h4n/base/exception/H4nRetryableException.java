package site.h4n.base.exception;

public class H4nRetryableException extends RuntimeException{
    public H4nRetryableException() {
    }

    public H4nRetryableException(String message) {
        super(message);
    }
}
