package com.huarui.springboot_07.service;

import com.huarui.springboot_07.pojo.Girl;

import java.util.List;

/**
 * @ Author       : 肖宇
 * @ Date         : Created in 17:30 2019/3/14
 * @ Description  : 业务层
 */
public interface GirlService {
    List<Girl> finaAll();

    boolean addGirl(Girl girl);

    boolean delGirl(Integer id);

    Girl ByIdSelectGirl(Integer id);

    boolean updateGirl(Girl girl);
}
