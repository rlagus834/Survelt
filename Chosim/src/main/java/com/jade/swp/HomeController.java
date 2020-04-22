package com.jade.swp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jade.swp.service.SpringRedisExample;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	HttpSession session;
	
	@Autowired
	private SpringRedisExample exam;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		exam.exam();
		return "home";
		
		
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {		
		return "home";
	}
	

	
	@RequestMapping(value = "/loginWrite", method = RequestMethod.GET)
	public String LoginWrite(@RequestParam("id") String id) {		
		session.setAttribute("id", id);
	   return "redirect:/main";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login() {		
		return "Login";
	}
	
	
	
	
}
