package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBClose;
import DB.DBConnection;
import DTO.Menu_Dto;

public class Menu_Dao_impl implements Menu_Dao {

	@Override
	public List<Menu_Dto> getMenuList() {
		String sql = " SELECT SEQ,NAME,SMALL,TALL,GRANDE "
				+ " FROM DRINKMENU "
				+ " ORDER BY SEQ ASC ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		
		List<Menu_Dto> list = new ArrayList<Menu_Dto>();
		
		try {
			conn=DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Menu_Dto dto = new Menu_Dto(rs.getInt(1),
											rs.getString(2),
											rs.getInt(3),
											rs.getInt(4),
											rs.getInt(5)
				);
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return list;
	}

}
