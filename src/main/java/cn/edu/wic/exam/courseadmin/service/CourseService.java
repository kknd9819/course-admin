package cn.edu.wic.exam.courseadmin.service;

import cn.edu.wic.exam.courseadmin.domain.dto.CourseDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface CourseService {

    String CACHE_KEY = "exam:course";

    /**
     * 分页查询课程
     * @param current 从第几页开始查
     * @param size 每页查多少条记录
     * @return 分页结果
     */
    IPage<CourseDTO> getPage(Integer current, Integer size);
}
