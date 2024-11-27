package cn.edu.wic.exam.courseadmin.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "公共返回对象")
public class R<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -6673028348147208714L;

    @Schema(description = "是否成功")
    private boolean succeed;

    @Schema(description = "消息")
    private String msg;

    @Schema(description = "数据")
    private T data;

    public static R<Void> success() {
        return new R<>(true, "success", null);
    }

    public static R<Void> success(String msg) {
        return new R<>(true, msg, null);
    }

    public static <T> R<T> success(T data) {
        return new R<>(true, "success", data);
    }

    public static R<Void> fail(String msg) {
        return new R<>(false, msg, null);
    }

}
