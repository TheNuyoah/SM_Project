package com.Angelo.service;


import com.Angelo.dto.Page;
import com.Angelo.pojo.ScheduleClass;
import com.Angelo.pojo.Score;
import com.Angelo.res.RestFulBean;

import java.util.List;
import java.util.Map;

public interface ScheduleClassService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<ScheduleClass> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param scheduleClass 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(ScheduleClass scheduleClass);

    /**
     * 修改数据
     *
     * @param scheduleClass 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(ScheduleClass scheduleClass);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> getList(Page<ScheduleClass> page) throws Exception;

    RestFulBean<Map> getChooseList(Page<ScheduleClass> page) throws Exception;

    RestFulBean<Map> getCourseByUserId(Page<ScheduleClass> page) throws Exception;

    RestFulBean<List<Score>> getStudentList(ScheduleClass scheduleClass);

}
