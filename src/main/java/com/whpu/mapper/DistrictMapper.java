package com.whpu.mapper;

import com.whpu.pojo.District;

import java.util.List;

public interface DistrictMapper {
    List<District> selectAllDistrict();

    //单查询
    List<District> selectOneDistrict(int did);
}
