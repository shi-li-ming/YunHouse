package com.whpu;

import com.whpu.mapper.DistrictMapper;
import com.whpu.mapper.HomeMapper;
import com.whpu.mapper.TypeMapper;
import com.whpu.mapper.UserMapper;
import com.whpu.pojo.District;
import com.whpu.pojo.House;
import com.whpu.pojo.Type;
import com.whpu.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

   @Autowired
    private HomeMapper homeMapper;
   @Autowired
   private TypeMapper typeMapper;
   @Autowired
   private DistrictMapper districtMapper;
   @Autowired
   private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void select(){
        List<House> house=homeMapper.selectAllHome();
        System.out.println("house:="+house);
    }
    @Test
    void type(){
      List<Type> type=typeMapper.selectAllType();

    }
    @Test
    void dis(){
        List<District> dis=districtMapper.selectAllDistrict();
}
    @Test
    void selectone(){
        Users user=userMapper.selectOneUser(1);
    }
    @Test
    void dele(){
        userMapper.deleteUser(12);
    }
    @Test
    void one(){
        List<District> dis= districtMapper.selectOneDistrict(1);
    }
    @Test
    void sfindone(){
        House house=homeMapper.selectonehouse(1);
    }
    @Test
    void updatehouse(){
        House house =new House();
        house.setAreas(123.0);
        house.setHid(10);
        homeMapper.updatehouse(house);
    }
}
