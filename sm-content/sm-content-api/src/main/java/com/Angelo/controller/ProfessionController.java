package com.Angelo.controller;

import com.Angelo.dto.Page;
import com.Angelo.pojo.Profession;
import com.Angelo.res.RestFulBean;
import com.Angelo.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * (Profession)表控制层
 *
 * @author makejava
 * @since 2022-08-05 10:45:21
 */
@RestController
@RequestMapping("/profession")
public class ProfessionController {
    /**
     * 服务对象
     */
    @Autowired
    private ProfessionService professionService;

    /**
     *  获取专业下拉数据
     * @param
     * @return Map
     */
    @PostMapping("/get/list")
    public RestFulBean<List<Profession>> getList() throws Exception {
        return professionService.getList();
    }
    /**
     *  新增
     * @param
     * @return Map
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Profession profession) throws Exception {
        return professionService.insert(profession);
    }
    /**
     *  修改
     * @param
     * @return Map
     */
    @PostMapping("/update")
    public RestFulBean<String> update(@RequestBody Profession profession) throws Exception {
        return professionService.update(profession);
    }
    /**
     *  新增
     * @param
     * @return Map
     */
    @PostMapping("/delete")
    public RestFulBean<String> delete(@RequestBody Profession profession) throws Exception {
        return professionService.deleteById(profession.getId());
    }
    /**
     *  分页查询
     * @param
     * @return Map
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Profession> page) throws Exception {
        return professionService.getPageList(page);
    }
}
