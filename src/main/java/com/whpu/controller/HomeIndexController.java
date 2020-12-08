package com.whpu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whpu.mapper.DistrictMapper;
import com.whpu.mapper.HomeMapper;
import com.whpu.mapper.TypeMapper;
import com.whpu.pojo.District;
import com.whpu.pojo.House;
import com.whpu.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
     @RequestMapping("/front")

     public class HomeIndexController {
     @Autowired
     private TypeMapper typeMapper;
     @Autowired
     private DistrictMapper districtMapper;
     @Autowired
     private HomeMapper homeMapper;
    //访问前台页面
    @RequestMapping("/front")
    public ModelAndView front(ModelAndView mv){
        mv.setViewName("/front/home_index");
        return mv;
    }
    //查询房屋
    @RequestMapping("/selectHome")
    public ModelAndView select(ModelAndView mv){
   //房屋类型
        List<Type> type=typeMapper.selectAllType();
    //城区
        List<District> dis=districtMapper.selectOneDistrict(1);
        mv.addObject("types",type);
        mv.addObject("districts",dis);
        mv.setViewName("/front/home_list");
        return  mv;

    }
    @RequestMapping("/showHomeList")
    @ResponseBody
    public PageInfo<House> list(@RequestParam(defaultValue="1") Integer pageNum,
                                    @RequestParam(defaultValue="8") Integer pageSize,
                                    String district_id, String type_id, String area, String price ){

        PageHelper.startPage(pageNum, pageSize);
       List<House> homes = homeMapper.selectAllHome();
      //  List<House> homes = homeMapper.selectByQuery(query);
        return new PageInfo<>(homes);
    }
}
