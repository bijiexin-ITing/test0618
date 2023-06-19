package com.qst.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.qst.entity.Auser;
@Repository("adminDao")
@Mapper
public interface AdminDao {
    public List<Auser> login(Auser auser);
    public List<Auser> queryAuser();
    public int  addUser(Auser user);
    public int updateUser(Auser auser);
    public int  deleteUser(Auser user);
}