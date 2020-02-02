package SERVICE;

import DAO.Mem_Dao;
import DAO.Mem_Dao_impl;
import DTO.Mem_Dto;

public class Mem_Service_impl implements Mem_Service {

	Mem_Dao dao = new Mem_Dao_impl();
	@Override
	public boolean addMember(Mem_Dto mem_Dto) {
		return dao.addMember(mem_Dto);
	}
	@Override
	public Mem_Dto login(String id, String pw) {
		
		return dao.login(id,pw);
	}

}
