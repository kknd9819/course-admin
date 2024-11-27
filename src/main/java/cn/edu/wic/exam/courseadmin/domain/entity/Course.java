package cn.edu.wic.exam.courseadmin.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@TableName("wic_course")
@Schema(description = "课程")
public class Course implements Serializable {

    @Serial
    private static final long serialVersionUID = -3050384822680003355L;

    @TableId(type = IdType.AUTO)
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

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新人")
    private String updateBy;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
