package com.mapper;

import com.domain.SystemUser2;
import java.util.List;

public interface SystemUser2Mapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemUser2 record);

    SystemUser2 selectByPrimaryKey(Long id);

    List<SystemUser2> selectAll();

    int updateByPrimaryKey(SystemUser2 record);
}