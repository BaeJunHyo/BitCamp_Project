package SERVICE;

import java.util.List;

import DTO.OrderTotal_Dto;

public interface Total_Service {

	void totalOrder(OrderTotal_Dto dto);

	List<OrderTotal_Dto> getOrder(String id);


	


	

}
