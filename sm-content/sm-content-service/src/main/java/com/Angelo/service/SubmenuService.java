package com.Angelo.service;

import com.Angelo.pojo.Submenu;
import com.Angelo.res.RestFulBean;

public interface SubmenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Submenu> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param submenu 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Submenu submenu);

    /**
     * 修改数据
     *
     * @param submenu 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Submenu submenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
