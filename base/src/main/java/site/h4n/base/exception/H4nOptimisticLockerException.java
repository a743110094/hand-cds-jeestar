package site.h4n.base.exception;

/**
 * H4N 乐观锁异常
 * 当更新冲突时 抛出
 * @author Heaven96
 * @date 2024/03/21
 */
public class H4nOptimisticLockerException extends H4nRetryableException{
    public H4nOptimisticLockerException() {
        super("乐观锁发生更新冲突");
    }

    public H4nOptimisticLockerException(String message) {
        super(message);
    }
}
