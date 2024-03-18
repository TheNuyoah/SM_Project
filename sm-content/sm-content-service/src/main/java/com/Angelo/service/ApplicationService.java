package com.Angelo.service;

import com.Angelo.dto.Page;
import com.Angelo.pojo.Application;
import com.Angelo.res.RestFulBean;

import java.util.Map;

public interface ApplicationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Application> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param application 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Application application);

    /**
     * 修改数据
     *
     * @param application 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Application application);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> getList(Page<Application> page) throws Exception;
}
