package com.example.mywork.mapper;

import com.example.mywork.model.user;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper 
{
	public user loginProc(user pInfo);
}
