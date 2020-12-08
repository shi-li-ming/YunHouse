package com.whpu.mapper;

import com.whpu.pojo.House;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface HomeMapper {
    @Results(id = "houseMap",value = {
            //手动封装users表数据
            @Result(column = "uid",property = "users.uid"),
            @Result(column = "name",property = "users.name"),
            @Result(column = "pwd",property = "users.pwd"),
            @Result(column = "sex",property = "users.sex"),
            @Result(column = "birth",property = "users.birth"),
            @Result(column = "head_img",property = "users.head_img"),
            @Result(column = "role",property = "users.role"),
            //district表
            @Result(column = "did",property = "district.did"),
            @Result(column = "parentid",property = "district.parentid"),
            @Result(column = "dis_name",property = "district.dis_name"),
            //type表
            @Result(column = "typeid",property = "type.typeid"),
            @Result(column = "typedesc",property = "type.typedesc")

    })
    //查询房屋信息
    List<House> selectAllHome();
    //添加
    void AddHouse(House house);
    //单查询
    House selectonehouse(int hid);
    //修改
    void updatehouse(House house);

    //删除
    void  deletehouse(int hid);

    //条件查询

}
