package cn.edu.wic.exam.courseadmin.service;

import cn.edu.wic.exam.courseadmin.domain.dto.CourseDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface CourseService {

    String CACHE_KEY = "exam:course";

    IPage<CourseDTO> getPage();
}
