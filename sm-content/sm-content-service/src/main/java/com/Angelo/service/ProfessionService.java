package com.Angelo.service;

import com.Angelo.dto.Page;
import com.Angelo.pojo.Profession;
import com.Angelo.res.RestFulBean;

import java.util.List;
import java.util.Map;

public interface ProfessionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Profession> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param profession 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Profession profession);

    /**
     * 修改数据
     *
     * @param profession 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Profession profession);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Profession>> getList();

    RestFulBean<Map> getPageList(Page<Profession> page) throws Exception;
}
