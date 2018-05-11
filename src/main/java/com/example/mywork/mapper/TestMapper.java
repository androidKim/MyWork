package com.example.mywork.mapper;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface TestMapper 
{
    String getTime();
}
