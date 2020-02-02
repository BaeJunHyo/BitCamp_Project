package Controller;

import javax.swing.JOptionPane;

import DTO.Mem_Dto;
import SERVICE.Mem_Service;
import SERVICE.Mem_Service_impl;
import SingleTon.Singleton;
import VIEW.AccountAdd_View;
import VIEW.Login_View;

public class Mem_Controller {

	Mem_Service mem_Service = new Mem_Service_impl();

	public void Login_View() {
		new Login_View();

	}

	public void account_Add_View() {
		new AccountAdd_View();
	}
	

	public void accAdd(String id, String pw, String name, String age) {
		boolean b = mem_Service.addMember(new Mem_Dto(id, pw, name, age, 3));

		if (b) {
			JOptionPane.showMessageDialog(null, "회원가입 완료");
			Login_View();
		} else {
			JOptionPane.showMessageDialog(null, "회원가입 실패");
		}
	}

	public void login(String id, String pw) {
		
		Mem_Dto dto = mem_Service.login(id,pw);
		
		if(dto == null) {
			JOptionPane.showMessageDialog(null, "ID/PW가 다릅니다");
		}else {
			JOptionPane.showMessageDialog(null, dto.getId()+"님 환영합니다.");
			Singleton s = Singleton.getInstance();
			s.setLoginID(dto.getId());
			s.menu_controller.orderMain();
					
		}

	}

}
