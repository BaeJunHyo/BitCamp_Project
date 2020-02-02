package SERVICE;

import DTO.Mem_Dto;

public interface Mem_Service {

	boolean addMember(Mem_Dto mem_Dto);

	Mem_Dto login(String id, String pw);
	

}
