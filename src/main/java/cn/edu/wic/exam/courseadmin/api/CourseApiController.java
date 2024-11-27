package cn.edu.wic.exam.courseadmin.api;

import cn.edu.wic.exam.courseadmin.domain.dto.CourseDTO;
import cn.edu.wic.exam.courseadmin.service.CourseService;
import cn.edu.wic.exam.courseadmin.util.JsonResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "课程API控制器")
@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseApiController {

    private final CourseService courseService;

    @Operation(summary = "分页获取课程")
    @Parameters({
        @Parameter(name = "current", description = "从第几页开始", required = true, in = ParameterIn.QUERY),
        @Parameter(name = "size", description = "一共显示几条数据", required = true, in = ParameterIn.QUERY)
    })
    @GetMapping
    public JsonResult<IPage<CourseDTO>> getPage(@RequestParam(value = "current", defaultValue = "1") Integer current,
                                                @RequestParam(value = "size", defaultValue = "20") Integer size) {
        return JsonResult.success(courseService.getPage(current, size));
    }
}
