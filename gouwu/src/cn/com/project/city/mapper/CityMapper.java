package cn.com.project.city.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.project.city.domain.City;
@Repository("cityMapper")
public interface CityMapper {
	List<City> selSheng();
	List<City> selShi(Integer sid);
	List<City> selXian(Integer sid);
	
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}