package com.zrcx.tutu.travelMg.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.common.dao.BaseDao;
import com.zrcx.tutu.travelMg.bean.Travel;

@Repository(value="travelDao")
public class TravelDao extends BaseDao{

	public List<Travel> getTravelPage(String ctId, int begin, int size) {
		Session session = getSession();
		Query query = session.createQuery("from Travel where travel_name like ? order by itemid desc");
		query.setString(0, ctId);
		query.setFirstResult(begin);
		query.setMaxResults(size);
		return query.list();
	}

	public Long getCount(String ctId) {
		Session session = getSession();
		Query query = session.createQuery("select count(itemid) from Travel where travel_name like ?");
		query.setString(0, ctId);
		return (Long)query.uniqueResult();
	}
	
	

}
