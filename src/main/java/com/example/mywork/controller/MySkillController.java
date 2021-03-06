package com.example.mywork.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mywork.util.Util;

@Controller
public class MySkillController
{     
	/******************************* Define *******************************/
	private static final Logger logger = LoggerFactory.getLogger(MySkillController.class);

	/******************************* Member *******************************/
	public Util m_Util = new Util();
   
    /******************************* User Function *******************************/
    //-----------------------------------------------------------------------------
    //
    @RequestMapping(value = "/mySkillMain")
    public ModelAndView mySkillMain(Model model, HttpServletRequest request, HttpServletResponse response) 
    {	    	
    		ModelAndView mav = new ModelAndView();
		mav.setViewName("my_skill_main");
		return mav;
    } 
}