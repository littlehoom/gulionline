package com.guli.edu.mapper;

import com.guli.edu.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guli.edu.vo.CourseWebVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author lzh
 * @since 2019-08-02
 */
public interface CourseMapper extends BaseMapper<Course> {
    CourseWebVo selectCourseWebVoById(String courseId);

}
