package com.qst.service.admin;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.qst.dao.AdminDao;
import com.qst.dao.AdminTypeDao;
/*import com.qst.dao.AdminTypeDao;*/
import com.qst.entity.Auser;
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AdminTypeDao adminTypeDao;
    @Override
    public String login(Auser auser, Model model, HttpSession session) {
        if(adminDao.login(auser) != null && adminDao.login(auser).size() > 0) {
            session.setAttribute("auser", auser);
            //添加商品与修改商品页面使用
            session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
            return "admin/main";
        }
        model.addAttribute("msg", "用户名或密码错误！");
        return "admin/login";
    }
    @Override
    public String queryAuser(Model model, HttpSession session) {
        // TODO Auto-generated method stub
        List <Auser> list=adminDao.queryAuser();
        model.addAttribute("ausers", list);
        return null;
    }
    @Override
    public String addUser(Auser auser) {
        // TODO Auto-generated method stub
        adminDao.addUser(auser);
        return null;
    }
    @Override
    public String deleteUser(Auser auser) {
        // TODO Auto-generated method stub
        adminDao.deleteUser(auser);
        return null;
    }
	@Override
	public String updateUser(Auser auser) {
		// TODO Auto-generated method stub
			adminDao.updateUser(auser);
		return null;
	}

}
