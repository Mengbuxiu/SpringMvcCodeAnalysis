package cn.zl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Alin
 * @version 1.0
 * @description // test
 * @date 2019/7/16 21:47
 */
@Controller
@RequestMapping("/test")
public class HelloController {
    /* 当未在dispatcher-servlet中添加视图解析器时，spring会有默认的视图解析器，
        但需写绝对路径，因为没有配置前缀和后缀
    @GetMapping("/hello")
    public String hello(){
        return "/WEB-INF/hello.jsp";
    }*/
    @GetMapping("/hello")
    public String hello(){
        //这里是配置了视图解析器的
        return "hello";
    }
    @GetMapping("/model")
    public String testModel(Model model){
        //页面传值
        model.addAttribute("word","hello");
        return "hello";
    }
    @GetMapping("/mv")
    public ModelAndView modelAndView(){
        //传值 + 转发视图
        ModelAndView view = new ModelAndView();
        view.setViewName("hello");
        view.addObject("word","getting");
        return view;
    }
}
