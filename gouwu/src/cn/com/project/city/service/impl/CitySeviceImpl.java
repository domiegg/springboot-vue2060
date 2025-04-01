package cn.com.project.city.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.project.city.domain.City;
import cn.com.project.city.mapper.CityMapper;
import cn.com.project.city.service.CityService;
@Service("cityService")
public class CitySeviceImpl implements CityService {
	@Autowired
	private CityMapper cityMapper;
	
	public List<City> selSheng() throws Exception {
		List<City> listSheng = cityMapper.selSheng();
		return listSheng;
	}

	public List<City> selShi(Integer sid) throws Exception {
		List<City> listShi = cityMapper.selShi(sid);
		return listShi;
	}

	public List<City> selXian(Integer sid) throws Exception {
		List<City> listXian = cityMapper.selXian(sid);
		return listXian;
	}

}
