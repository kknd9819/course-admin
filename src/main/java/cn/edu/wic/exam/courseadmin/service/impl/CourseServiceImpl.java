package cn.edu.wic.exam.courseadmin.service.impl;

import cn.edu.wic.exam.courseadmin.domain.dto.CourseDTO;
import cn.edu.wic.exam.courseadmin.mapper.CourseMapper;
import cn.edu.wic.exam.courseadmin.service.CourseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
    public IPage<CourseDTO> getPage() {
        return null;
    }
}
