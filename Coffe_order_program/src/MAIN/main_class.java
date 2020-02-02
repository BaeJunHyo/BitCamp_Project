package MAIN;

import DB.DBConnection;
import SingleTon.Singleton;

public class main_class {
	public static void main(String[] args) {
		DBConnection.initConnection();
		Singleton s = Singleton.getInstance();
		
		s.mem_controller.Login_View();

	}
}
