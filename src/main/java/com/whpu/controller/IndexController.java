package com.whpu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whpu.mapper.UserMapper;
import com.whpu.pojo.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller

@RequestMapping("/user")
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/index")
    public ModelAndView index(ModelAndView mv){
        mv.setViewName("index");
        return  mv;
    }
    @RequestMapping("/admin")
    public ModelAndView admin(ModelAndView mv){
        mv.setViewName("main");
        return mv ;
    }

    //查询列表
    @RequestMapping("/select")
    public ModelAndView select (ModelAndView mv, @RequestParam(defaultValue = "1") Integer pageNo,
                                @RequestParam(defaultValue = "4") Integer pageSize){
        //分页查询
        PageHelper.startPage(pageNo,pageSize);
        List<Users> user=userMapper.selectAllUser();
        PageInfo<Users> pageinfo =new PageInfo<>(user);
        System.out.println(pageinfo);
        mv.addObject("user",pageinfo);
        mv.setViewName("/user/select");
         return mv;
    }
    //添加
    @RequestMapping("/add")
    public ModelAndView add(ModelAndView mv, Users users){

        userMapper.AddUser(users);
        mv.setViewName("redirect:/user/select");
        return mv;
    }
  //单查询
    @RequestMapping("/selectOneUser")
      public ModelAndView selectone(ModelAndView mv,@RequestParam(value="uid") int uid){
      Users users=userMapper.selectOneUser(uid);
      mv.addObject("u",users);
        return  mv;
    }
    //修改
    @RequestMapping("/update")
    public ModelAndView update(ModelAndView mv,@RequestParam(value="uid") int uid, Users users,@RequestParam(value="flag") String flag){
      //  System.out.println("update====");
        if(flag.equals("1")){
             Users user=userMapper.selectOneUser(uid);
             System.out.println(user);
             mv.addObject("users",user);
             mv.setViewName("/user/update");
        }
       else {
           userMapper.updateUser(users);
            mv.setViewName("redirect:/user/select");
        }
        return  mv;
        }

        //删除
    @RequestMapping("/delete")
    public ModelAndView delete(ModelAndView mv,@RequestParam(value = "uid") int uid){
        userMapper.deleteUser(uid);
        mv.setViewName("redirect:/user/select");
        return  mv;
    }

}
