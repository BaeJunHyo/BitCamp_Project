package SingleTon;

import java.util.ArrayList;
import java.util.List;

import Controller.Mem_Controller;
import Controller.OrderTotal_Controller;
import DTO.OrderTotal_Dto;
import Controller.Menu_Controller;

public class Singleton {
	
	private static Singleton s = null;

	
	public Mem_Controller mem_controller = null;
	public Menu_Controller menu_controller = null;
	public OrderTotal_Controller total_controller = null;
	
	
	private String loginID =null;
	public List<OrderTotal_Dto> dto = null;
	
	
	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	//기본생성자
	public Singleton() {
		// TODO Auto-generated constructor stub
		mem_controller = new Mem_Controller();
		menu_controller = new Menu_Controller();
		total_controller = new OrderTotal_Controller();
		dto = new ArrayList<OrderTotal_Dto>();
	}
	
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton();
		}
		return s;
	}

}
