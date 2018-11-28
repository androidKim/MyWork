package com.example.mywork.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.mywork.mapper.MainMapper;
import com.example.mywork.util.Util;

@Controller
public class MainController
{     
	/******************************* Define *******************************/
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	/******************************* Member *******************************/
	public Util m_Util = new Util();
    
	@Autowired
	MainMapper mapper;

    /******************************* User Function *******************************/
    //-----------------------------------------------------------------------------
    //
    @RequestMapping(value = "/")
    public String redirect(Model model, HttpServletRequest request, HttpServletResponse response) 
    {	    	
    	
		return "redirect:/meMain";
    }
    //-----------------------------------------------------------------------------
    //
    @RequestMapping(value = "/main")
    public String main(Model model, HttpServletRequest request, HttpServletResponse response) 
    {	    	
    		return "redirect:/meMain";
    } 
}