package Controller;

import java.util.List;

import DTO.Menu_Dto;
import SERVICE.Menu_Service;
import SERVICE.Menu_Service_impl;
import VIEW.Menu_View;
import VIEW.OrderMain_View;

public class Menu_Controller {

	Menu_Service menuService = new Menu_Service_impl();

	public void orderMain() {
		new OrderMain_View();
	}

	public void MenuList() {
		List<Menu_Dto> list = menuService.getMenuList();
		new Menu_View(list);
	}

	public int MenuList(String coffe, String size, int drinkCount) {
		int totalPay = 0;
		List<Menu_Dto> list = menuService.getMenuList();

		for (int i = 0; i < list.size(); i++) {
			if (coffe.equals(list.get(i).getDrinkName())) {
				switch (size) {
				case "small":
					totalPay = drinkCount * list.get(i).getSmall();
					break;
				case "tall":
					totalPay = drinkCount * list.get(i).getTall();
					break;
				case "grande":
					totalPay = drinkCount * list.get(i).getGrande();
					break;
				}
			}
		} // for close
		return totalPay;
	}

	

}
