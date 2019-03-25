package com.huarui.springboot_07.controller;

import com.huarui.springboot_07.pojo.Girl;
import com.huarui.springboot_07.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ Author       : 肖宇
 * @ Date         : Created in 18:17 2019/3/15
 * @ Description  : 控制器
 */
@Controller
@RequestMapping("/girls")
public class GirlController {
    @Autowired
    GirlService girlService;

    @GetMapping
    public String listGirl(Model model) {
        List<Girl> girls = girlService.finaAll();
        model.addAttribute("girls", girls);
        return "list";
    }

    @GetMapping("/from")
    public String from(Model model) {
        model.addAttribute("girl", new Girl());
        return "from";
    }

    @PostMapping("/addGirl")
    public String addGirl(Girl girl, Model model) {
        boolean add = girlService.addGirl(girl);
        return listGirl(model);
    }

    @GetMapping("/delGirl/{id}")
    public String delGirl(@PathVariable("id") Integer id, Model model) {
        System.out.print("------删除-------");
        boolean delGirl = girlService.delGirl(id);
        return listGirl(model);
    }

    @GetMapping("/ByIdSelectGirl/{id}")
    public String ByIdSelectGirl(@PathVariable("id") Integer id, Model model) {
        Girl girl = girlService.ByIdSelectGirl(id);
        model.addAttribute("girl", girl);
        return "modify";
    }

    @GetMapping("/updateGirl")
    public String updateGirl(Girl girl, Model model) {
        girlService.updateGirl(girl);
        return listGirl(model);
    }
}
