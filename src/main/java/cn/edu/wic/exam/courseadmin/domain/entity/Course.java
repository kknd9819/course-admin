package cn.edu.wic.exam.courseadmin.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@TableName("wic_course")
public class Course implements Serializable {

    @Serial
    private static final long serialVersionUID = -3050384822680003355L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 课程名
     */
    private String courseName;

    /**
     * 课程描述
     */
    private String courseDesc;

    /**
     * 课时
     */
    private Integer classHour;

    /**
     * 学分
     */
    private Integer score;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
