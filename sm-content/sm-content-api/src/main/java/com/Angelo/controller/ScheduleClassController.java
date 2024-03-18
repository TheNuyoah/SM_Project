package com.Angelo.controller;

import com.Angelo.dto.Page;
import com.Angelo.pojo.ScheduleClass;
import com.Angelo.pojo.Score;
import com.Angelo.res.RestFulBean;
import com.Angelo.service.ScheduleClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/scheduleClass")
public class ScheduleClassController {
    /**
     * 服务对象
     */
    @Autowired
    private ScheduleClassService scheduleClassService;

    /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<ScheduleClass> page) throws Exception{
        return this.scheduleClassService.getList(page);
    }
    /**
     * 分页查询获取选修课
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/choose/list")
    public RestFulBean<Map> getChooseList(@RequestBody Page<ScheduleClass> page) throws Exception{
        return this.scheduleClassService.getChooseList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param scheduleClass 主键
     * @return 单条数据
     */
    @PostMapping("/get/by/id")
    public RestFulBean<ScheduleClass> queryById(@RequestBody ScheduleClass scheduleClass) {
        return this.scheduleClassService.queryById(scheduleClass.getId());
    }

    /**
     * 新增数据
     *
     * @param scheduleClass 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody ScheduleClass scheduleClass) {
        return this.scheduleClassService.insert(scheduleClass);
    }

    /**
     * 编辑数据
     *
     * @param scheduleClass 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody ScheduleClass scheduleClass) {
        return this.scheduleClassService.update(scheduleClass);
    }

    /**
     * 删除数据
     *
     * @param scheduleClass
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody ScheduleClass scheduleClass) {
        return this.scheduleClassService.deleteById(scheduleClass.getId());
    }
    /**
     * 获取教师所教的课程
     *
     * @param
     * @return
     */
    @PostMapping("/get/course/by/userId")
    public RestFulBean<Map> getCourseByUserId(@RequestBody Page<ScheduleClass> page) throws Exception{
        return this.scheduleClassService.getCourseByUserId(page);
    }

    //获取教师所教课程的学生
    @PostMapping("/get/studentList")
    public RestFulBean<List<Score>> getStudentList(@RequestBody ScheduleClass scheduleClass) throws Exception {
        return scheduleClassService.getStudentList(scheduleClass);
    }

}
