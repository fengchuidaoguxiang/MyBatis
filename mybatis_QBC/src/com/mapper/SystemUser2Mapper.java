package com.mapper;

import com.domain.SystemUser2;
import com.domain.SystemUser2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemUser2Mapper {
    long countByExample(SystemUser2Example example);

    int deleteByExample(SystemUser2Example example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemUser2 record);

    int insertSelective(SystemUser2 record);

    List<SystemUser2> selectByExample(SystemUser2Example example);

    SystemUser2 selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemUser2 record, @Param("example") SystemUser2Example example);

    int updateByExample(@Param("record") SystemUser2 record, @Param("example") SystemUser2Example example);

    int updateByPrimaryKeySelective(SystemUser2 record);

    int updateByPrimaryKey(SystemUser2 record);
}