package com.Angelo.controller;

import com.Angelo.dto.Page;
import com.Angelo.pojo.ChooseCourse;
import com.Angelo.res.RestFulBean;
import com.Angelo.service.ChooseCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/chooseCourse")
public class ChooseCourseController {
    /**
     * 服务对象
     */
    @Autowired
    private ChooseCourseService chooseCourseService;

    /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<ChooseCourse> page) throws Exception{
        return this.chooseCourseService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param chooseCourse
     * @return 单条数据
     */
    @PostMapping("/get/by/id")
    public RestFulBean<ChooseCourse> queryById(@RequestBody ChooseCourse chooseCourse) {
        return this.chooseCourseService.queryById(chooseCourse.getId());
    }

    /**
     * 新增数据
     *
     * @param chooseCourse 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody ChooseCourse chooseCourse) {
        return this.chooseCourseService.insert(chooseCourse);
    }

    /**
     * 编辑数据
     *
     * @param chooseCourse 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody ChooseCourse chooseCourse) {
        return this.chooseCourseService.update(chooseCourse);
    }

    /**
     * 删除数据
     *
     * @param chooseCourse
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody ChooseCourse chooseCourse) {
        return this.chooseCourseService.deleteById(chooseCourse.getId());
    }

}
