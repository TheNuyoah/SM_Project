package com.Angelo.controller;

import com.Angelo.dto.Page;
import com.Angelo.pojo.Score;
import com.Angelo.res.RestFulBean;
import com.Angelo.service.ScoreService;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/score")
public class ScoreController {
    /**
     * 服务对象
     */
    @Autowired
    private ScoreService scoreService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Score> page) throws Exception{
        return this.scoreService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param score
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Score> queryById(@RequestBody Score score) {
        return this.scoreService.queryById(score.getId());
    }

    /**
     * 新增数据
     *
     * @param score 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Score score) {
        return this.scoreService.insert(score);
    }

    /**
     * 编辑数据
     *
     * @param score 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Score score) {
        return this.scoreService.update(score);
    }

    /**
     * 删除数据
     *
     * @param score
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Score score) {
        return this.scoreService.deleteById(score.getId());
    }
    /**
     * 获取教师所教课程学生名单跟分数
     *
     * @param
     * @return
     */
    @PostMapping("/get/by/course/score")
    public RestFulBean<List<Score>> getScoreList(@RequestBody Score score) {
        return this.scoreService.getScoreList(score);
    }
    //教师打印所教科目的成绩
    @PostMapping("/export")
    public RestFulBean<Map> export(@RequestBody Score score) throws WriteException, IOException {
        return scoreService.export(score);
    }
    /**
     * 根据学生id获取成绩
     *
     * @param
     * @return
     */
    @PostMapping("/get/by/userId")
    public RestFulBean<List<Score>> getStudentScoreList(@RequestBody Page<Score>page) {
        return this.scoreService.getStudentScoreList(page);
    }
}

