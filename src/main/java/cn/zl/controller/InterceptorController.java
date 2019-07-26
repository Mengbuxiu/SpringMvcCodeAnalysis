package cn.zl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Alin
 * @version 1.0
 * @description // test
 * @date 2019/7/16 21:47
 */
@Controller
@RequestMapping("/chain")
public class InterceptorController {
    @GetMapping("/1")
    public String testInterceptor1(Model model){
        //页面传值
        model.addAttribute("word","chain-1");
        return "hello";
    }
    @GetMapping("/2")
    public String testInterceptor2(Model model){
        //页面传值
        model.addAttribute("word","chain-2");
        return "hello";
    }
}
