package Controller;

import java.util.ArrayList;
import java.util.List;

import DTO.Menu_Dto;
import DTO.OrderTotal_Dto;
import SERVICE.Total_Service;
import SERVICE.Total_Service_impl;
import SingleTon.Singleton;
import VIEW.All_View;
import VIEW.Cart_View;

public class OrderTotal_Controller {

	Total_Service totalService = new Total_Service_impl();
	
	public OrderTotal_Dto cartList(String coffe, String size, String syrup, String shot, String cream, int drinkCount) {

		int pay = 0;
		String id = null;
		Singleton s = Singleton.getInstance();
		pay = s.menu_controller.MenuList(coffe, size, drinkCount);
		id = s.getLoginID();
		
		System.out.println(id);
		
		OrderTotal_Dto dto = null; 
		dto = new OrderTotal_Dto(0,id,coffe,size,syrup,shot,cream,drinkCount,pay,null);
		
		
		return dto;
		
	}

	public List<OrderTotal_Dto> listShow(String loginID) {
		return totalService.getOrder(loginID);
		
		
	}
	
	public void cartView(List<OrderTotal_Dto> list) {
		new Cart_View(list);
	}
	
	public void addOrder(OrderTotal_Dto dto) {
		totalService.totalOrder(dto);
	}

	public void allView(List<OrderTotal_Dto> list) {
		new All_View(list);
		
	}
	
	// TODO Auto-generated method stub
	
	
}
