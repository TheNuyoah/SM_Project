package com.Angelo.mapper;

import com.Angelo.dto.Page;
import com.Angelo.pojo.ScheduleClass;
import com.Angelo.pojo.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ScoreMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Score queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Score> getPageListByCondition(@Param("page") Page<Score> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Score> page);


    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 影响行数
     */
    int insert(Score score);




    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 影响行数
     */
    int update(Score score);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Score> getScoreList(ScheduleClass scheduleClass);

    List<Score> queryByScheduleClassId(Integer id);

    List<Score> getStudentScoreList(@Param("page") Page<Score> page);

    List<Score> getScoreList1(ScheduleClass scheduleClass);
}

