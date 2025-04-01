package cn.com.project.web.user.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.project.web.user.domain.UsedBook;
@Repository("usedBookMapper")
public interface UsedBookMapper {
    void deleteByPrimaryKey(Integer id);

    void insert(UsedBook record);

    void insertSelective(UsedBook record);

    List<UsedBook> selectList();
    
    List<UsedBook> selectByPrimaryKey(Integer id);

    void updateByPrimaryKeySelective(UsedBook record);

    void updateByPrimaryKey(UsedBook record);
}