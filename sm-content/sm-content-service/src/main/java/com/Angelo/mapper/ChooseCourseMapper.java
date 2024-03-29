package com.Angelo.mapper;


import com.Angelo.dto.Page;
import com.Angelo.pojo.ChooseCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChooseCourseMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ChooseCourse queryById(Integer id);


    /**
     * 新增数据
     *
     * @param chooseCourse 实例对象
     * @return 影响行数
     */
    int insert(ChooseCourse chooseCourse);


    /**
     * 修改数据
     *
     * @param chooseCourse 实例对象
     * @return 影响行数
     */
    int update(ChooseCourse chooseCourse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);



    ChooseCourse getByUserIdAndCourseId(ChooseCourse chooseCourse);

    List<ChooseCourse> getPageListByCondition(@Param("page") Page<ChooseCourse> page);

    Integer getPageListCount(@Param("page") Page<ChooseCourse> page);

    List<ChooseCourse> getByCourseId(Integer courseId, Integer year, String term);


}
