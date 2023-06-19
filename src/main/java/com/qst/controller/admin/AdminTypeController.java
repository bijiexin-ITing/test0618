package com.qst.controller.admin;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qst.entity.Goods;
/*import com.qst.entity.Goods;*/
import com.qst.service.admin.AdminTypeService;
@Controller
@RequestMapping("/adminType")
public class AdminTypeController extends BaseController{
    @Autowired
    private AdminTypeService adminTypeService;
    /**
     * 到添加类型页面
     */
    @RequestMapping("/toAddType")
    public String toAddType(Model model) {
        return adminTypeService.toAddType(model);
    }
    @RequestMapping("/toAddType2")
    public String toAddType2(Model model) {
        model.addAttribute("goods",new Goods());
        return adminTypeService.toAddType2(model);
    }
    /**
     * 添加类型
     */
    @RequestMapping("/addType")
    public String addType(String typename,Model model,HttpSession session) {
        return adminTypeService.addType(typename, model, session);
    }
    @RequestMapping("/addType2")
    public String addType2(@ModelAttribute Goods goods,String typename,Model model,HttpSession session) {
        return adminTypeService.addType2(goods.getGoodstype_id(),typename, model, session);
    }
    
    /**
     * 到删除页面
     */
    @RequestMapping("/toDeleteType")
    public String toDeleteType(Model model) {
        return adminTypeService.toDeleteType(model);
    }
    /**
     * 删除类型
     */
    @RequestMapping("/deleteType")
    public String deleteType(Integer id,Model model) {
        return adminTypeService.deleteType(id, model);
    }
    
}