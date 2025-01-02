package cn.edu.wic.exam.courseadmin.service.impl;

import cn.edu.wic.exam.courseadmin.domain.dto.CourseDTO;
import cn.edu.wic.exam.courseadmin.service.CourseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class CourseServiceImplTest {

    @Autowired
    private CourseService courseService;


    @Test
    void getPage() {
        IPage<CourseDTO> pageInfo = courseService.getPage(0, 20);
        Assertions.assertNotNull(pageInfo);
    }

    @Test
    void getById() {
        CourseDTO courseDTO = courseService.getById(1);
        Assertions.assertNotNull(courseDTO);
    }

    @Test
    @Transactional
    @Rollback
    void insert() {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseName("英语");
        courseDTO.setCourseDesc("学好走遍世界都不怕");
        courseDTO.setClassHour(32);
        courseDTO.setScore(100);
        courseDTO.setCreateBy("admin");
        int c = courseService.insert(courseDTO);
        Assertions.assertEquals(1, c);
    }

    @Test
    @Transactional
    @Rollback
    void updateById() {
        CourseDTO courseDTO = courseService.getById(1);
        courseDTO.setScore(150);
        int c = courseService.updateById(courseDTO);
        Assertions.assertEquals(1, c);
    }

    @Test
    @Transactional
    @Rollback
    void deleteById() {
        int c = courseService.deleteById(1);
        Assertions.assertEquals(1, c);
    }
}