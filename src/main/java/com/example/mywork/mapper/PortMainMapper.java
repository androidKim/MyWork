package com.example.mywork.mapper;

import java.util.ArrayList;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.example.mywork.model.portfolio;


@Mapper
public interface PortMainMapper 
{
	public void setPortfolio(portfolio pInfo);
	public void modPortfolio(portfolio pInfo);
	public void deletePort(String seq);
	public portfolio getPortDetail(String seq);
    public ArrayList<portfolio> getPortList();
}
