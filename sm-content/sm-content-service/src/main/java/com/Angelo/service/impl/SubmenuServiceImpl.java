package com.Angelo.service.impl;

import com.Angelo.mapper.SubmenuMapper;
import com.Angelo.pojo.Submenu;
import com.Angelo.res.RestFulBean;
import com.Angelo.service.SubmenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("submenuService")
public class SubmenuServiceImpl implements SubmenuService {
    @Autowired
    private SubmenuMapper submenuMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Submenu> queryById(Integer id) {
       Submenu submenu=this.submenuMapper.queryById(id);
         return RestFulBean.succ(submenu);
    }

    /**
     * 新增数据
     *
     * @param submenu 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Submenu submenu) {
        this.submenuMapper.insert(submenu);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param submenu 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Submenu submenu) {
        this.submenuMapper.update(submenu);
        return RestFulBean.succ("修改成功");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.submenuMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }
}
