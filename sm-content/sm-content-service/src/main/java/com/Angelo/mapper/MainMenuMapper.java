package com.Angelo.mapper;


import com.Angelo.pojo.MainMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MainMenuMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MainMenu queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询条件
     * @param limit   查询条数
     * @return 对象列表
     */
    List<MainMenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 统计总行数
     *
     * @param mainMenu 查询条件
     * @return 总行数
     */
    long count(MainMenu mainMenu);

    /**
     * 新增数据
     *
     * @param mainMenu 实例对象
     * @return 影响行数
     */
    int insert(MainMenu mainMenu);



    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MainMenu> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MainMenu> entities);

    /**
     * 修改数据
     *
     * @param mainMenu 实例对象
     * @return 影响行数
     */
    int update(MainMenu mainMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    void addMenu(MainMenu mainMenu);

    void updateMainMenu(MainMenu mainMenu);

    List<MainMenu> getMainMenu();

    List<MainMenu> getMenuTree(String type);
}

