package cn.com.project.web.user.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.project.web.user.domain.PingJia;
@Repository("pingJiaMapper")
public interface PingJiaMapper {
    void deleteByPrimaryKey(Integer id);

    void insert(PingJia record);

    void insertSelective(PingJia record);

    List<PingJia> selectByPrimaryKey(Integer id);
    List<PingJia> select(PingJia pj);

    void updateByPrimaryKeySelective(PingJia record);

    void updateByPrimaryKey(PingJia record);
}