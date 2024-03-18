package com.Angelo.controller;

import com.Angelo.dto.Page;
import com.Angelo.pojo.Course;
import com.Angelo.res.RestFulBean;
import com.Angelo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    /**
     * 服务对象
     */
    @Autowired
    private CourseService courseService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Course> page) throws Exception{
        return this.courseService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param course 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Course> queryById(@RequestBody Course course) {
        return this.courseService.queryById(course.getId());
    }

    /**
     * 新增数据
     *
     * @param course 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Course course) {
        return this.courseService.insert(course);
    }

    /**
     * 编辑数据
     *
     * @param course 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Course course) {
        return this.courseService.update(course);
    }

    /**
     * 删除数据
     *
     * @param course 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Course course) {
        return this.courseService.deleteById(course.getId());
    }
    /**
     * 根据专业id获取课程
     *
     * @param
     * @return
     */
    @PostMapping("/get/by/professionId")
    public RestFulBean<List<Course>> getByprofessionId(@RequestBody Course course) {
        return this.courseService.getByprofessionId(course.getProfessionId());
    }
}

