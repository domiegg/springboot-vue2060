package cn.com.project.city.service;

import java.util.List;

import cn.com.project.city.domain.City;

public interface CityService {
	List<City> selSheng()throws Exception;
	List<City> selShi(Integer sid)throws Exception;
	List<City> selXian(Integer sid)throws Exception;
}
