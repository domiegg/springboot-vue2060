package cn.com.project.web.user.mapper;

import java.util.List;

import cn.com.project.web.user.domain.Liuyan;

public interface LiuyanMapper {
    void deleteLy(Integer id);

    void insertLy(Liuyan record);


    List<Liuyan> selectListLy(Liuyan record);

    void updateByPrimaryKeySelective(Liuyan record);

    void updateByPrimaryKey(Liuyan record);
}