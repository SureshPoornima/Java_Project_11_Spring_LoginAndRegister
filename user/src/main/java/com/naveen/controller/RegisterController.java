package com.naveen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naveen.model.User;
import com.naveen.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	public UserService UserService;

	@RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView home() {
	ModelAndView mv = new ModelAndView("home");
	return mv;
}
    @RequestMapping(value = "/register", method = RequestMethod.GET) 
    public ModelAndView showRegister(){
    	ModelAndView mav = new ModelAndView("register");
    	return mav;
    }
    @RequestMapping(value= "/registerProcess", method = RequestMethod.POST)
    public ModelAndView LoginProcess(HttpServletRequest request, HttpServletRequest response,User user) {
    UserService.register(user);
    return new ModelAndView("hello","firstname",user.getFirstname());
    }
    
}
