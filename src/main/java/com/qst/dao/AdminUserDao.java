package com.qst.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.qst.entity.Buser;

@Repository("adminUserDao")
@Mapper
public interface AdminUserDao {
	public List<Buser> userInfo();
	public int deleteuserManager(Integer id);
}
