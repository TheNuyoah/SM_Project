package com.Angelo.service;

import com.Angelo.dto.Page;
import com.Angelo.pojo.ClasseHistory;
import com.Angelo.res.RestFulBean;

import java.util.Map;
public interface ClasseHistoryService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<ClasseHistory> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<ClasseHistory> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param classeHistory 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(ClasseHistory classeHistory);

    /**
     * 修改数据
     *
     * @param classeHistory 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(ClasseHistory classeHistory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
