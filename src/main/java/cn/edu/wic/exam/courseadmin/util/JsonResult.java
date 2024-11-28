package cn.edu.wic.exam.courseadmin.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "公共返回对象")
public class JsonResult<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -6673028348147208714L;

    @Schema(description = "是否成功")
    private boolean succeed;

    @Schema(description = "消息")
    private String msg;

    @Schema(description = "数据")
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

    public static JsonResult<?> failWithBindResult(BindingResult bindingResult) {
        List<ObjectError> errorList = bindingResult.getAllErrors();
        String errors = errorList.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", "));
        return fail(errors);
    }
}
