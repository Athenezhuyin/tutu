package com.zrcx.tutu.travelMg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JsonUtil;

import org.springframework.stereotype.Service;

import com.zrcx.tutu.travelMg.bean.Travel;
import com.zrcx.tutu.travelMg.dao.TravelDao;
import com.zrcx.tutu.travelMg.service.TravelService;

@Service(value="travelService")
public class TravelServiceImpl implements TravelService{

	@Resource(name="travelDao")
	private TravelDao travelDao;
	
	@Override
	public void save(Travel travel) {
		System.out.println("service:"+travel);
		travelDao.save(travel);
		System.out.println("save");
	}

	@Override
	public Travel findById(Long id) {
		System.out.println("findById");
		return (Travel)travelDao.get(Travel.class,id);
	}

	@Override
	public void update(Travel travel) {
		System.out.println("update");
		travelDao.update(travel);
	}

	@Override
	public void delete(Long id) {
		System.out.println("delete");
		Travel travel = new Travel();
		travel.setId(id);
		travelDao.delete(travel);
	}

	@Override
	public Object[] getTravelPage(String ctId, int begin, int size) {
		System.out.println("getTravelPage");
		List<Travel> list = travelDao.getTravelPage(ctId, begin, size);
		Long count = travelDao.getCount(ctId);
		return new Object[]{count, JsonUtil.fromObject(list)};
	}

	
	
}
