package com.whpu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whpu.mapper.DistrictMapper;
import com.whpu.mapper.HomeMapper;
import com.whpu.mapper.TypeMapper;
import com.whpu.mapper.UserMapper;
import com.whpu.pojo.District;
import com.whpu.pojo.House;
import com.whpu.pojo.Type;
import com.whpu.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/house")
public class HomeController {
    @Autowired
    private HomeMapper homeMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private DistrictMapper districtMapper;
    @RequestMapping("/selectHome")
    public ModelAndView selectHome(ModelAndView mv, @RequestParam(defaultValue = "1") Integer pageNo,
                                   @RequestParam(defaultValue = "4") Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<House> house=homeMapper.selectAllHome();
        //查询用户
        List<Users>  user=userMapper.selectAllUser();
        //房屋类型
        List<Type> type=typeMapper.selectAllType();
        //查询区域信息
       // List<District> dis=districtMapper.selectAllDistrict();
        List<District> dis=districtMapper.selectOneDistrict(1);
        //house封装到分页
        PageInfo<House>  housePageInfo=new PageInfo<>(house);
        //添加用户
        mv.addObject("user",user);
        mv.addObject("house",housePageInfo);
        mv.addObject("type",type);
        mv.addObject("dis",dis);
        mv.setViewName("/house/select");
        return  mv;
    }

    //添加房屋信息
    @RequestMapping("/addHome")
    public ModelAndView add(ModelAndView mv,House house){
        homeMapper.AddHouse(house);
        mv.setViewName("redirect:/house/selectHome");
        return mv;
    }

    @RequestMapping("/selectone")
    @ResponseBody
    //城区和街道二级联动
    public  List<District> streets(@RequestParam() Integer did){
        return  districtMapper.selectOneDistrict(did);
    }

    //修改
    @RequestMapping("/update")
    public ModelAndView update(ModelAndView mv,String flag,int hid,House house){
        if(flag.equals("1")){
            //查询用户
            List<Users>  user=userMapper.selectAllUser();
            //房屋类型
            List<Type> type=typeMapper.selectAllType();
            //查询区域
            List<District> dis=districtMapper.selectOneDistrict(1);
            //单查询
            House houses=homeMapper.selectonehouse(hid);
            mv.addObject("houses",houses);
            mv.addObject("user",user);
            mv.addObject("type",type);
            mv.addObject("dis",dis);
            mv.setViewName("/house/update");
        }
        else{
            homeMapper.updatehouse(house);
            //重定向跳转
            mv.setViewName("redirect:/house/selectHome");
        }
        return mv;
    }
    //删除
    @RequestMapping("/delete")
    public ModelAndView delete(ModelAndView mv,int hid){
        homeMapper.deletehouse(hid);
        mv.setViewName("redirect:/house/selectHome");
        return  mv;
    }
}
