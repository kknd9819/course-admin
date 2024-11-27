package cn.edu.wic.exam.courseadmin.controller;

import cn.edu.wic.exam.courseadmin.domain.dto.CourseDTO;
import cn.edu.wic.exam.courseadmin.util.R;
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

@Tag(name = "课程控制器")
@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    @Operation(summary = "分页获取课程")
    @Parameters({
            @Parameter(name = "pageNumber", description = "从第几页开始", in = ParameterIn.QUERY),
            @Parameter(name = "pageSize", description = "一共显示几条数据", in = ParameterIn.QUERY)
    })
    @GetMapping
    public R<IPage<CourseDTO>> getPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                       @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        return R.success();
    }
}
