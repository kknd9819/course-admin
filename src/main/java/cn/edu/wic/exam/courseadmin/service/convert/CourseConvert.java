package cn.edu.wic.exam.courseadmin.service.convert;

import cn.edu.wic.exam.courseadmin.domain.dto.CourseDTO;
import cn.edu.wic.exam.courseadmin.domain.entity.Course;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseConvert {

    public static CourseDTO toDto(Course entity) {
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setCourseName(entity.getCourseName());
        dto.setCourseDesc(entity.getCourseDesc());
        dto.setClassHour(entity.getClassHour());
        dto.setScore(entity.getScore());
        dto.setCreateBy(entity.getCreateBy());
        dto.setUpdateBy(entity.getUpdateBy());
        dto.setCreateTime(entity.getCreateTime());
        dto.setUpdateTime(entity.getUpdateTime());
        return dto;
    }

    public static List<CourseDTO> toDto(List<Course> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.emptyList();
        }
        List<CourseDTO> list = new ArrayList<>(entityList.size());
        for (Course entity : entityList) {
            list.add(toDto(entity));
        }
        return list;
    }

    public static Course toEntity(CourseDTO dto) {
        Course entity = new Course();
        entity.setId(dto.getId());
        entity.setCourseName(dto.getCourseName());
        entity.setCourseDesc(dto.getCourseDesc());
        entity.setClassHour(dto.getClassHour());
        entity.setScore(dto.getScore());
        entity.setCreateBy(dto.getCreateBy());
        entity.setCreateTime(dto.getCreateTime());
        entity.setUpdateBy(dto.getUpdateBy());
        entity.setUpdateTime(dto.getUpdateTime());
        return entity;
    }

    public static Page<CourseDTO> convertPage(IPage<Course> page) {
        if (page == null) {
            return null;
        }
        Page<CourseDTO> pageInfo = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        pageInfo.setRecords(toDto(page.getRecords()));
        return pageInfo;
    }
}
