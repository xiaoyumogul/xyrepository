package com.huarui.springboot_07.mapper;

import com.huarui.springboot_07.pojo.Girl;
import com.huarui.springboot_07.pojo.GirlExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GirlMapper {
    long countByExample(GirlExample example);

    int deleteByExample(GirlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Girl record);

    int insertSelective(Girl record);

    List<Girl> selectByExample(GirlExample example);

    Girl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Girl record, @Param("example") GirlExample example);

    int updateByExample(@Param("record") Girl record, @Param("example") GirlExample example);

    int updateByPrimaryKeySelective(Girl record);

    int updateByPrimaryKey(Girl record);
}