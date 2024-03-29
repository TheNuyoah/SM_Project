package com.Angelo.service;

import com.Angelo.dto.Users;
import com.Angelo.pojo.MainMenu;
import com.Angelo.pojo.Submenu;
import com.Angelo.res.RestFulBean;

import java.util.List;

public interface MainMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<MainMenu> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param mainMenu 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(MainMenu mainMenu);

    /**
     * 修改数据
     *
     * @param mainMenu 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(MainMenu mainMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);
    /**
     * 获取系统菜单栏
     *
     * @param user
     */
    RestFulBean<List<MainMenu>> getMenuTree(Users user) throws Exception;


    RestFulBean<String> addMenu(Submenu submenu)throws Exception;

    RestFulBean<String> addMainMenu(MainMenu mainMenu);

    RestFulBean<String> updateMainMenu(MainMenu mainMenu);

    RestFulBean<String> updateMenu(Submenu submenu);

    RestFulBean<String> delMenu(Submenu submenu);

    RestFulBean<String> delMainMenu(MainMenu mainMenu);
}
