package com.Angelo.service;

import com.Angelo.dto.Page;
import com.Angelo.pojo.ChooseCourse;
import com.Angelo.res.RestFulBean;

import java.util.Map;

public interface ChooseCourseService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<ChooseCourse> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param chooseCourse 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(ChooseCourse chooseCourse);

    /**
     * 修改数据
     *
     * @param chooseCourse 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(ChooseCourse chooseCourse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> getList(Page<ChooseCourse> page) throws Exception;


}
