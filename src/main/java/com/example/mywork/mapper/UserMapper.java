package com.example.mywork.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.mywork.model.user;

@Mapper
public interface UserMapper 
{
	public user loginProc(user pInfo);
}
