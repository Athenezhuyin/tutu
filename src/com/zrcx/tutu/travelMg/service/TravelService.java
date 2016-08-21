package com.zrcx.tutu.travelMg.service;

import com.zrcx.tutu.travelMg.bean.Travel;

public interface TravelService {

	public void save(Travel travel);

	public Travel findById(Long id);

	public void update(Travel travel);

	public void delete(Long id);

	public Object[] getTravelPage(String ctId, int begin, int size);


}
