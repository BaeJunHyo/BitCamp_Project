package SERVICE;

import java.util.List;

import DAO.Total_Dao;
import DAO.Total_Dao_impl;
import DTO.OrderTotal_Dto;

public class Total_Service_impl implements Total_Service {
	Total_Dao dao = new Total_Dao_impl();

	@Override
	public void totalOrder(OrderTotal_Dto dto) {
		dao.totalOrder(dto);
		
	}

	@Override
	public List<OrderTotal_Dto> getOrder(String id) {
		// TODO Auto-generated method stub
		return dao.getOrder(id);
	}

		
	

	
	
	

	

	

}
