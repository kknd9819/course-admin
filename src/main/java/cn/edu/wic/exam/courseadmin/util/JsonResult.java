package cn.edu.wic.exam.courseadmin.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -6673028348147208714L;

    private boolean succeed;

    private String msg;

    private T data;

    public static JsonResult<Void> success() {
        return new JsonResult<>(true, "success", null);
    }

    public static JsonResult<Void> success(String msg) {
        return new JsonResult<>(true, msg, null);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<>(true, "success", data);
    }

    public static JsonResult<Void> fail(String msg) {
        return new JsonResult<>(false, msg, null);
    }

    public static <T> JsonResult<T> fail(String msg, T data) {
        return new JsonResult<>(false, msg, data);
    }
}
