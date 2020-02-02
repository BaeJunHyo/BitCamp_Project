package DAO;

import DTO.Mem_Dto;

public interface Mem_Dao {

	boolean addMember(Mem_Dto mem_Dto);

	Mem_Dto login(String id, String pw);
	
}
