package com.huarui.springboot_07.service;

import com.huarui.springboot_07.mapper.GirlMapper;
import com.huarui.springboot_07.pojo.Girl;
import com.huarui.springboot_07.pojo.GirlExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author       : 肖宇
 * @ Date         : Created in 18:04 2019/3/15
 * @ Description  : 实现类
 */
@Service
public class GirlServiceImpl implements GirlService {
    @Autowired
    GirlMapper girlMapper;

    @Override
    public List<Girl> finaAll() {
        GirlExample girlExample = new GirlExample();
        return girlMapper.selectByExample(girlExample);
    }

    @Override
    public boolean addGirl(Girl girl) {
        int insert = girlMapper.insert(girl);
        return insert > 0;
    }

    @Override
    public boolean delGirl(Integer id) {
        int i = girlMapper.deleteByPrimaryKey(id);
        return i > 0;
    }

    @Override
    public Girl ByIdSelectGirl(Integer id) {
        return girlMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateGirl(Girl girl) {
        int i = girlMapper.updateByPrimaryKey(girl);
        return i > 0;
    }
}
