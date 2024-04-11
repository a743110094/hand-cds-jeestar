package site.h4n.base.entity;

import lombok.Data;

@Data
public class Result {
    private Integer code;
    private String message;
    private String traceId;
    private String path;
    private Object data;

    public static Result success() {
        Result result = new Result();
        result.setCode(2000);
        result.setMessage("操作成功");
         return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(2000);
        result.setMessage("成功");
        result.setData(data);
         return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.setCode(5000);
         result.setMessage("请求发生错误");
        return result;
    }

    public static Result fail(String message) {
        return fail(message, null, 500);
    }

    public static Result fail(String message, String path) {
        return fail(message, path, 500);
    }

    public static Result fail(String message, String path, Integer code) {
        Result result = new Result();
        result.setCode(code);
         result.setMessage(message);
        result.setPath(path);
        return result;
    }
}
