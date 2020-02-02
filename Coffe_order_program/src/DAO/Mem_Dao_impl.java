package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBClose;
import DB.DBConnection;
import DTO.Mem_Dto;

public class Mem_Dao_impl implements Mem_Dao {

	
	public boolean addMember(Mem_Dto mem_Dto) {
		String sql = " INSERT INTO COFFEMEM(ID,PWD,NAME,AGE,AUTH) "
				+ " VALUES(?,?,?,?,3)";
		
		int count = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn= DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem_Dto.getId());
			psmt.setString(2, mem_Dto.getPwd());
			psmt.setString(3, mem_Dto.getName());
			psmt.setString(4, mem_Dto.getAge());
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		
		return count>0?true:false;
	}

	@Override
	public Mem_Dto login(String id, String pw) {
		String sql = " SELECT ID,NAME,AGE,AUTH "
				+ " FROM COFFEMEM "
				+ " WHERE ID=? AND PWD=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Mem_Dto dto = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String _id = rs.getString(1);
				String _name = rs.getString(2);
				String _age = rs.getString(3);
				int auth = rs.getInt(4);
				
				dto = new Mem_Dto(_id,null,_name,_age,auth);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
			
		}
		
		return dto;
	}

}
