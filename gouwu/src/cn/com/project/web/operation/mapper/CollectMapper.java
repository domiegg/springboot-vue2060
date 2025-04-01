package cn.com.project.web.operation.mapper;

import java.util.List;

import cn.com.project.web.operation.domain.Collect;

public interface CollectMapper {
    void deleteByPrimaryKey(Integer id);

    void insert(Collect record);

    void insertSelective(Collect record);

    List<Collect> selectByPrimaryKey(Integer id);

    void updateByPrimaryKeySelective(Collect record);

    void updateByPrimaryKey(Collect record);
}