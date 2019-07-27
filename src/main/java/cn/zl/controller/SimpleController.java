package cn.zl.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alin
 * @desc //TODO
 * @date 2019/7/24
 */
public class SimpleController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("I'm in----------------simple");
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("word","simple");
        return modelAndView;
    }
}
