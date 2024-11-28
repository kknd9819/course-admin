package cn.edu.wic.exam.courseadmin.api;

import cn.edu.wic.exam.courseadmin.domain.dto.CourseDTO;
import cn.edu.wic.exam.courseadmin.service.CourseService;
import cn.edu.wic.exam.courseadmin.util.InsertAction;
import cn.edu.wic.exam.courseadmin.util.JsonResult;
import cn.edu.wic.exam.courseadmin.util.UpdateAction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Tag(name = "课程API控制器")
@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseApiController {

    private final CourseService courseService;

    @Operation(summary = "分页获取课程")
    @Parameters({
        @Parameter(name = "page", description = "从第几页开始", required = true, in = ParameterIn.QUERY),
        @Parameter(name = "limit", description = "一共显示几条数据", required = true, in = ParameterIn.QUERY)
    })
    @GetMapping
    public JsonResult<?> getPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "limit", defaultValue = "20") Integer limit) {
        return JsonResult.success(courseService.getPage(page, limit));
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据id获取单个课程")
    @Parameter(name = "id", description = "id", required = true, in = ParameterIn.PATH)
    public JsonResult<CourseDTO> getById(@PathVariable("id") Integer id) {
        return JsonResult.success(courseService.getById(id));
    }

    @Operation(summary = "新增课程")
    @PostMapping
    public JsonResult<?> save(@Validated({Default.class, InsertAction.class}) @RequestBody CourseDTO courseDTO,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.failWithBindResult(bindingResult);
        }
        int count = courseService.insert(courseDTO);
        return count > 0 ? JsonResult.success() : JsonResult.fail("新增课程失败");
    }

    @Operation(summary = "修改课程")
    @PutMapping
    public JsonResult<?> update(@Validated({Default.class, UpdateAction.class}) @RequestBody CourseDTO courseDTO,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.failWithBindResult(bindingResult);
        }
        int count = courseService.updateById(courseDTO);
        return count > 0 ? JsonResult.success() : JsonResult.fail("修改课程失败");
    }

    @Operation(summary = "删除课程")
    @Parameter(name = "id", description = "id", required = true, in = ParameterIn.PATH)
    @DeleteMapping("/{id}")
    public JsonResult<?> delete(@PathVariable("id") Integer id) {
        int count = courseService.deleteById(id);
        return count > 0 ? JsonResult.success() : JsonResult.fail("删除课程失败");
    }
}
