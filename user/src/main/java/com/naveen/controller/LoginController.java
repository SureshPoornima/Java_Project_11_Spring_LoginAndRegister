package com.naveen.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.naveen.model.Login;
import com.naveen.model.User;
import com.naveen.service.UserService;
@Controller
public class LoginController {
	@Autowired
	UserService userService;
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	     public ModelAndView showHome() {
	     ModelAndView mav = new ModelAndView("home");
	     
	     return mav;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin() {
	    ModelAndView mav = new ModelAndView("login");
	    return mav;
	}
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	     public ModelAndView LoginProcess(HttpServletRequest request,HttpServletResponse response,Login loginn ) {
	     ModelAndView mav = null;
	     User user = userService.validateUser(loginn);
	     if(null != user) {
	    mav = new ModelAndView("hello");
	    mav.addObject("firstname", user.getFirstname());
	     }
	     else {
	    mav = new ModelAndView("login");
	    mav.addObject("message", "Username or Password is wrong!!");
	     }
	     return mav;
	}
}