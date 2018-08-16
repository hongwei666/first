package com.ghw.controller;

import com.ghw.pojo.Page;
import com.ghw.pojo.UserOld;
import com.ghw.service.UserService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Api(value = "restful", description = "UserController类")
public class UserController {

    @Autowired
    private UserService userService;


    //列出所有用户
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "分页返回用户信息(开发责任人：高宏伟)", notes = "test: 分页返回所有用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "start", value = "起始页", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "last", value = "最后一页", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "count", value = "总页码", required = true, dataType = "String"),
    })
    public ModelAndView listUser(Page page) {
        ModelAndView mav = new ModelAndView();
        if (page.getStart() < 0) {
            page.setStart(0);
        }
        PageHelper.offsetPage(page.getStart(), 5);
        List<UserOld> cs = userService.list();
        // 放入转发参数
        mav.addObject("cs", cs);
        // 放入jsp路径
        mav.setViewName("listUser");
        return mav;
    }

    //分页列出所有用户
    @RequestMapping("/listUsersByPage")
    public ModelAndView listUsersByPage(Page page) {
        ModelAndView mav = new ModelAndView();
        if (0 > page.getStart()) {
            page.setStart(0);
        }
        List<UserOld> userOlds = userService.listUsersByPage(page);
        mav.addObject("cs", userOlds);
        int total = userService.total();
        page.caculateLast(total);
        mav.setViewName("listUser");
        return mav;
    }

    //增加用户
    @RequestMapping("/addUser")
    public ModelAndView addUser(UserOld userOld) {
        userService.addUser(userOld);
        ModelAndView mav = new ModelAndView("redirect:/list");
        return mav;
    }

    //删除用户
    @RequestMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        ModelAndView mav = new ModelAndView("redirect:/list");
        return mav;
    }

    //编辑用户
    @RequestMapping("editUser")
    public ModelAndView editUser(UserOld userOld) {
        userService.editUser(userOld);
        ModelAndView mav = new ModelAndView("redirect:/list");
        return mav;
    }

    //跳转编辑用户界面
    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        UserOld userOld1 = userService.getUser(id);
        ModelAndView mav = new ModelAndView("editUser");
        mav.addObject("user", userOld1);
        return mav;
    }

    //根据id查询用户
    @RequestMapping(value = "/find/{id}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据用户id查询用户", notes = "test: 返回的是User对象或者字符串")
    @ApiImplicitParam(paramType = "path", name = "id", value = "1", required = true, dataType = "String")
    public Object finduserbyid(@PathVariable("id") int id) {
        UserOld userOld = userService.getUser(id);
        if (null == userOld) {
            return "id is not cunzai";
        }
        return userOld;
    }

    //根据用户名模糊查询用户
    @RequestMapping(value = "/findUserByName/{name}", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户名模糊查询用户", notes = "返回的是User对象")
    @ResponseBody
    public List<UserOld> findUserByName(@PathVariable("name") String name) {
        return userService.findUserByName(name);
    }
}