package com.whpu.mapper;


import com.whpu.pojo.Users;

import java.util.List;

public interface UserMapper   {

     //查询所有用户
     List<Users>  selectAllUser();
     //添加用户
     void AddUser(Users users);

     //单查询
     Users selectOneUser(int uid);

     //修改
     void updateUser(Users users);

     //删除
     void deleteUser(int uid);
}
