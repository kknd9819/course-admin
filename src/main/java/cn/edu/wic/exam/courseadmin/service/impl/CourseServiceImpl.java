package cn.edu.wic.exam.courseadmin.service.impl;

import cn.edu.wic.exam.courseadmin.domain.dto.CourseDTO;
import cn.edu.wic.exam.courseadmin.domain.entity.Course;
import cn.edu.wic.exam.courseadmin.mapper.CourseMapper;
import cn.edu.wic.exam.courseadmin.service.CourseService;
import cn.edu.wic.exam.courseadmin.service.convert.CourseConvert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = CourseService.CACHE_KEY)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;

    @Override
    public IPage<CourseDTO> getPage(Integer current, Integer size) {
        Page<Course> pageParam = new Page<>(current, size);
        Page<Course> page = courseMapper.selectPage(pageParam, null);
        return CourseConvert.convertPage(page);
    }

}
