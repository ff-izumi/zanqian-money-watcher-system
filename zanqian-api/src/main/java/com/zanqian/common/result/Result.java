package com.zanqian.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private int code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    public static <T> Result<T> success() {
        return new Result<>(200, "success", null);
    }

    public static Result<Object> error( Object data) {
        return new Result<>(500, "error", data);
    }


    public static Result<Object> error(int code, Object data) {
        return new Result<>(code, "error", data);
    }

}
