package SERVICE;

import java.util.List;

import DAO.Menu_Dao;
import DAO.Menu_Dao_impl;
import DTO.Menu_Dto;

public class Menu_Service_impl implements Menu_Service {

	Menu_Dao menuDao = new Menu_Dao_impl();
	@Override
	public List<Menu_Dto> getMenuList() {
		// TODO Auto-generated method stub
		return menuDao.getMenuList();
	}

}
