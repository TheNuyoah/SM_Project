package com.Angelo.controller;

import com.Angelo.dto.Users;
import com.Angelo.pojo.MainMenu;
import com.Angelo.pojo.Submenu;
import com.Angelo.res.RestFulBean;
import com.Angelo.service.MainMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/mainMenu")
public class MainMenuController {
    /**
     * 服务对象
     */
    @Autowired
    private MainMenuService mainMenuService;

    /**
     * 获取菜单
     *
     * @param  user 用户id 查出 该用户是什么角色 进而显示不同的菜单
     * @return Map<Object, Object>
     */
    @PostMapping("/menu")
    public RestFulBean<List<MainMenu>> getMenuTree(@RequestBody Users user) throws Exception {
        return mainMenuService.getMenuTree(user);
    }

    /**
     * 新增一个子菜单
     * @param  submenu
     * @return
     * @throws
     */
    @PostMapping("/add/menu")
    public RestFulBean<String> addMenu(@RequestBody Submenu submenu)throws Exception{
        return mainMenuService.addMenu(submenu);
    }
    /**
     * 新增一个主菜单
     * @param  mainMenu
     * @return
     * @throws
     */
    @PostMapping("/add/mainMenu")
    public RestFulBean<String> addMainMenu(@RequestBody MainMenu mainMenu)throws Exception{
        return mainMenuService.addMainMenu(mainMenu);
    }
    /**
     * 修改主菜单
     * @param  mainMenu
     * @return
     * @throws
     */
    @PostMapping("/update/mainMenu")
    public RestFulBean<String> updateMainMenu(@RequestBody MainMenu mainMenu)throws Exception{
        return mainMenuService.updateMainMenu(mainMenu);
    }
    /**
     * 修改子菜单
     * @param  submenu
     * @return
     * @throws
     */
    @PostMapping("/update/menu")
    public RestFulBean<String> updateMenu(@RequestBody Submenu submenu)throws Exception{
        return mainMenuService.updateMenu(submenu);
    }
    /**
     * 删除子菜单
     * @param  submenu
     * @return
     * @throws
     */
    @PostMapping("/del/menu")
    public RestFulBean<String> delMenu(@RequestBody Submenu submenu)throws Exception{
        return mainMenuService.delMenu(submenu);
    }
    /**
     * 删除主菜单
     * @param  mainMenu
     * @return
     * @throws
     */
    @PostMapping("/del/mainMenu")
    public RestFulBean<String> delMainMenu(@RequestBody MainMenu mainMenu)throws Exception{
        return mainMenuService.delMainMenu(mainMenu);
    }
}

