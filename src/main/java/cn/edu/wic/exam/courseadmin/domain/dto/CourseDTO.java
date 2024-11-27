package cn.edu.wic.exam.courseadmin.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(description = "课程")
public class CourseDTO {

    @Schema(description = "id")
    private Integer id;

    @Schema(description = "课程名称")
    private String courseName;

    @Schema(description = "课程描述")
    private String courseDesc;

    @Schema(description = "课时")
    private Integer classHour;

    @Schema(description = "学分")
    private Integer score;

    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "更新人")
    private String updateBy;
}