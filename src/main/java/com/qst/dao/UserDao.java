package com.qst.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.qst.entity.Buser;

@Repository("userDao")
@Mapper
public interface UserDao {
    public int register(Buser buser);
    public List<Buser> login(Buser buser);
}