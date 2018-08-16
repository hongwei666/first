package com.ghw.controller;

import com.ghw.pojo.RoleParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


@Controller
@RequestMapping("/params")
public class ParamsController {
    @RequestMapping("/commonParams/{name}")
    public ModelAndView commonParams(@PathVariable("name") String rolename) {
        System.out.println("rolename:" + rolename);
        RoleParams params = new RoleParams();
        params.setRolename("hello");
        params.setNote("note");
        ModelAndView mv = new ModelAndView();
        mv.addObject(params);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }
}
