package com.zrcx.tutu.travelMg.view;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.common.action.BaseAction;
import com.common.action.EasyUIAction;
import com.zrcx.tutu.travelMg.bean.Travel;
import com.zrcx.tutu.travelMg.service.TravelService;

@Controller
public class TravelAction extends EasyUIAction{
	
	@Resource(name="travelService")
	private TravelService travelService;
	
	private Travel travel;
	
	//http://localhost/Tutu/travelAction_saveOrUpdate.action?travel.travelName=xm
	//http://localhost/Tutu/travelAction_saveOrUpdate.action?travel.id=1&travel.travelName=ms
	public void saveOrUpdate(){
		System.out.println("action:"+travel);
		if(travel.getId() == null)
			travelService.save(travel);
		else
			travelService.update(travel);
	}
	
	//http://localhost/Tutu/travelAction_findById.action?travel.id=2
	public void findById(){
		System.out.println("action:"+travel);
		Travel travelBean = travelService.findById(travel.getId());
		writeJson(travelBean);
	}
	
	//http://localhost/Tutu/travelAction_delete.action?travel.id=3
	public void delete(){
		System.out.println("action:"+travel);
		travelService.delete(travel.getId());
		writeJson(travel);
	}

	//http://localhost/Tutu/travelAction_getTravelPage.action?travel.travelId=xm
	public void getTravelPage(){
		System.out.println("action:"+travel);
		String ctId = "%%";
		if(travel != null){
			String travelId = travel.getTravelId();
			if(travelId != null || !"".equals(travelId)){
				ctId = "%"+travelId+"%";
			}
		}
		Object[] objs = travelService.getTravelPage(ctId,(page-1)*rows, rows);
		writeJson("{\"total\":"+objs[0]+",\"rows\":"+objs[1]+"}");
	}
	
	
	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}
	
	
	
	
}
