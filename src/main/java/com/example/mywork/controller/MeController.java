package com.example.mywork.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mywork.mapper.PortMainMapper;
import com.example.mywork.model.portfolio;
import com.example.mywork.util.Util;

@Controller
public class MeController
{     
	/******************************* Define *******************************/
	private static final Logger logger = LoggerFactory.getLogger(MeController.class);

	/******************************* Member *******************************/
	public Util m_Util = new Util();
   

    /******************************* User Function *******************************/
    //-----------------------------------------------------------------------------
    //
    @RequestMapping(value = "/meMain")
    public ModelAndView meMain(Model model, HttpServletRequest request, HttpServletResponse response) 
    {	    	
        	ModelAndView mav = new ModelAndView();
		mav.setViewName("me_main");
		return mav;
    } 
}