package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.util.StringUtils;

import com.example.demo.dao.ClassroomDao;
import com.example.demo.entity.Classroom;

@Controller
public class ClassController {

	@Autowired
	private ClassroomDao classDao;
	
	
	@RequestMapping(value = "/admindex", method = RequestMethod.GET)
	private Model listClass(Model model) {
		// 班级列表
		
		List<Classroom> list = classDao.classRoomList();
		
		//for(Classroom classinfo:list){
			model.addAttribute("classinfo",list);
			System.out.println(list);
	//	}
		
		return model;
	}
	//添加班级
	@RequestMapping(value = "/postclass" , method = RequestMethod.POST)
    public Model addClass(Classroom aclass, Model model){
		Classroom class1 =classDao.findByClassname(aclass.getcName());
				
        if(StringUtils.isEmpty(aclass.getcName())){
           model.addAttribute("msg1", "班级名称不能为空，请重新填写");
            //return "register";
            return model;
        }else if(class1!=null){
        	if(class1!=null){
        		model.addAttribute("msg1","班级已经存在,请试试别的!");
                return model;
            }
        }else{
        	classDao.addClass(aclass);
            model.addAttribute("msg1","添加成功");
            return model;
           // return "index";
        }
		return model;
    }
	
	
	// 删除班级
	@GetMapping(value = "/deleteclass/{id}")
	//@ResponseBody
	private String deleteUser(@PathVariable("id") Integer cId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();	
		if(classDao.deleteClass(cId)==1){
		modelMap.put("msg", "删除成功");}
		//modelMap.put("success", userDao.deleteUser(uId));
		return "redirect:/admindex";
	}
	
	
	//显示当前班级，在页面回显
	
	@RequestMapping(value = "/upclass/{cname}",method={RequestMethod.GET})
		 public String ListClassBycName(@PathVariable("cname") String cname, Model model){
			Classroom classnow = classDao.findByClassname(cname);
			 model.addAttribute("classnow",classnow);
			 System.out.println("classnow: " + classnow);
			 return "upclass";
			//return model;
		 }
	
	@RequestMapping(value="/updateclass",method={RequestMethod.PUT})
    public String updateClass(Classroom aclass,Model model){
	//根据c_id，修改班级名称
	if( classDao.updateClass(aclass)==1){
	
	model.addAttribute("msg", "修改班级名称成功");
	}
	 return "redirect:/admindex";
    }	 
	 
}
