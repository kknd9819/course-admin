package cn.edu.wic.exam.courseadmin.api;

import cn.edu.wic.exam.courseadmin.domain.dto.CourseDTO;
import cn.edu.wic.exam.courseadmin.service.CourseService;
import cn.edu.wic.exam.courseadmin.util.InsertAction;
import cn.edu.wic.exam.courseadmin.util.JsonResult;
import cn.edu.wic.exam.courseadmin.util.UpdateAction;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseApiController {

    private final CourseService courseService;

    @GetMapping
    public JsonResult<?> getPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "limit", defaultValue = "20") Integer limit) {
        return JsonResult.success(courseService.getPage(page, limit));
    }

    @GetMapping("/{id}")
    public JsonResult<CourseDTO> getById(@PathVariable("id") Integer id) {
        return JsonResult.success(courseService.getById(id));
    }

    @PostMapping
    public JsonResult<?> save(@Validated({Default.class, InsertAction.class}) @RequestBody CourseDTO courseDTO) {
        int count = courseService.insert(courseDTO);
        return count > 0 ? JsonResult.success() : JsonResult.fail("新增课程失败");
    }

    @PutMapping
    public JsonResult<?> update(@Validated({Default.class, UpdateAction.class}) @RequestBody CourseDTO courseDTO) {
        int count = courseService.updateById(courseDTO);
        return count > 0 ? JsonResult.success() : JsonResult.fail("修改课程失败");
    }

    @DeleteMapping("/{id}")
    public JsonResult<?> delete(@PathVariable("id") Integer id) {
        int count = courseService.deleteById(id);
        return count > 0 ? JsonResult.success() : JsonResult.fail("删除课程失败");
    }
}
