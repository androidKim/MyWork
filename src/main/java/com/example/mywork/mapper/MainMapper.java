package com.example.mywork.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MainMapper 
{
    public HashMap<String, Object> getBoard();
}
