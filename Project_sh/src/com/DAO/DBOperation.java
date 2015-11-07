package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.Bean.Account;

public class DBOperation {
	
	public boolean createAccount(Account account) {
		DBConnection connection=new DBConnection();
		Connection con=connection.getConnection();
		boolean flag=false;
		String query="insert into account values('"+
				account.getFirstName()+"','"+account.getLastName()+"','"+
				account.getEmail()+"','"+account.getPassword()+"',"+account.getNumber()+",'"+
				account.getAltEmail()+"','"+account.getCountry()+"')";
		
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			if(pstmt.executeUpdate()>0)
				flag=true ;
			
			connection.closePrepareStmt(pstmt);
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
