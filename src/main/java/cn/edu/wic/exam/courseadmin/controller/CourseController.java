package cn.edu.wic.exam.courseadmin.controller;

import cn.edu.wic.exam.courseadmin.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public String index() {
        return "course/index";
    }

    @GetMapping("/edit")
    public String edit() {
        return "course/edit";
    }
}
