package com.whpu.pojo;

import lombok.Data;

@Data
public class House {
    private int hid;
    private int user_id;
    private int district_id;
    private int type_id;
    private Users users;
    private  District district;
    private  Type type;
    private Double price;
    private Double areas;
    private String title;
    private String mark;
    private String equipment;
    private String address;
    private String imgs;

}
