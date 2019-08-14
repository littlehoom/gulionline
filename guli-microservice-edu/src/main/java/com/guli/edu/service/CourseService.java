package com.guli.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.edu.form.CourseInfoForm;
import com.guli.edu.query.CourseQuery;
import com.guli.edu.vo.CourseWebVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author lzh
 * @since 2019-08-02
 */
public interface CourseService extends IService<Course> {

    String saveCourseInfo(CourseInfoForm courseInfoForm);

    CourseInfoForm getCourseInfoFormById(String id);

    void updateCourseInfoById(CourseInfoForm courseInfoForm);

    void pageQuery(Page<Course> pageParam, CourseQuery courseQuery);

    void removeCourseById(String id);

    Map<String,Object> pageListWeb(Page<Course> pageParam);

    /**
     * 获取课程信息
     * @param id
     * @return
     */
    CourseWebVo selectCourseWebVoById(String id);
    List<Course> selectByTeacherId(String teacherId);
}
