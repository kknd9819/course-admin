package cn.edu.wic.exam.courseadmin.domain.dto;

import cn.edu.wic.exam.courseadmin.util.InsertAction;
import cn.edu.wic.exam.courseadmin.util.UpdateAction;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

@Data
public class CourseDTO {

    @NotNull(message = "id不能为空", groups = {UpdateAction.class})
    private Integer id;

    /**
     * 课程名
     */
    @NotBlank(message = "课程名不能为空")
    private String courseName;

    /**
     * 课程描述
     */
    @Length(max = 255, message = "课程描述不能大于255个字")
    private String courseDesc;

    /**
     * 课时
     */
    @NotNull(message = "课时不能为空")
    @Range(min = 0, max = 255, message = "课时只能是0-255之间")
    private Integer classHour;

    /**
     * 学分
     */
    @NotNull(message = "学分不能为空")
    @Range(min = 0, max = 255, message = "学分只能是0-255之间")
    private Integer score;

    /**
     * 创建人
     */
    @NotBlank(message = "创建人不能为空",groups = {InsertAction.class})
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @NotBlank(message = "更新人不能为空", groups = {UpdateAction.class})
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
}
