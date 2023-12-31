package com.qst.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.qst.entity.Notice;
@Repository("adminNoticeDao")
@Mapper
public interface AdminNoticeDao {
	public int addNotice(Notice notice);
	public List<Notice> deleteNoticeSelect();
	public int deleteNotice(Integer id);
	public Notice selectANotice(Integer id);
}
