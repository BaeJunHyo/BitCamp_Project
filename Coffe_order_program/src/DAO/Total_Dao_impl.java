package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBClose;
import DB.DBConnection;
import DTO.OrderTotal_Dto;

public class Total_Dao_impl implements Total_Dao {
	/*
	 * 
	 * SEQ NUMBER(8) PRIMARY KEY, COFFE VARCHAR2(50) NOT NULL, dSIZE VARCHAR2(20)
	 * NOT NULL, SYRUP VARCHAR2(20) NOT NULL, SHOT VARCHAR2(5) NOT NULL, CREAM
	 * VARCHAR2(5) NOT NULL, QTY NUMBER(10) NOT NULL, PAY NUMBER(10) NOT NULL, wDATE
	 * DATE NOT NULL );
	 * 
	 */

	@Override
	public void totalOrder(OrderTotal_Dto dto) {
		
		String sql = " INSERT INTO TOTAL_ORDER(SEQ,USERID,COFFE,DSIZE,SYRUP,SHOT,CREAM,QTY,PAY,WDATE) "
				+ " VALUES(SEQ_TOTAL_ORDER.NEXTVAL,?,?,?,?,?,?,?,?,SYSDATE) ";


		System.out.println("test" + dto.getDrink());
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getDrink());
			psmt.setString(3, dto.getSize());
			psmt.setString(4, dto.getSyrup());
			psmt.setString(5, dto.getShot());
			psmt.setString(6, dto.getCream());
			psmt.setInt(7, dto.getDrinkCount());
			psmt.setInt(8, dto.getPayTotal());
			int test= psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

	}

	@Override
	public List<OrderTotal_Dto> getOrder(String id) {
		// TODO Auto-generated method stub
		
		String sql = " SELECT SEQ,USERID,COFFE,DSIZE,SYRUP,SHOT,CREAM,QTY,PAY,WDATE"
				+ "	FROM TOTAL_ORDER "
				+ " WHERE USERID=?"
				+ " ORDER BY SEQ DESC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
				
		List<OrderTotal_Dto> list = new ArrayList<OrderTotal_Dto>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id); 
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				OrderTotal_Dto dto = new OrderTotal_Dto(rs.getInt(1),
														rs.getString(2),
														rs.getString(3),
														rs.getString(4),
														rs.getString(5),
														rs.getString(6),
														rs.getString(7),
														rs.getInt(8),
														rs.getInt(9),
														rs.getString(10)
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
