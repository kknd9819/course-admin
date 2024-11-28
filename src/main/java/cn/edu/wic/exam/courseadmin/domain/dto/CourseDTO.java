package cn.edu.wic.exam.courseadmin.domain.dto;

import cn.edu.wic.exam.courseadmin.util.InsertAction;
import cn.edu.wic.exam.courseadmin.util.UpdateAction;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "课程")
public class CourseDTO {

    @NotNull(message = "id不能为空", groups = {UpdateAction.class})
    @Schema(description = "id")
    private Integer id;

    @NotBlank(message = "课程名不能为空")
    @Schema(description = "课程名称")
    private String courseName;

    @Schema(description = "课程描述")
    @Size(max = 255, message = "课程描述不能大于255个字")
    private String courseDesc;

    @NotNull(message = "课时不能为空")
    @Max(value = 255, message = "课程不能大于255")
    @Min(value = 0, message = "课时不能小于0")
    @Schema(description = "课时")
    private Integer classHour;

    @NotNull(message = "学分不能为空")
    @Max(value = 255, message = "学分不能大于255")
    @Min(value = 0, message = "学分不能小于0")
    @Schema(description = "学分")
    private Integer score;

    @NotBlank(message = "创建人不能为空",groups = {InsertAction.class})
    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @NotBlank(message = "更新人不能为空", groups = {UpdateAction.class})
    @Schema(description = "更新人")
    private String updateBy;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
}
