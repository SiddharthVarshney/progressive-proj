package com.sapient.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sapient.beans.User;
import com.sapient.utils.GetConnection;

import antlr.collections.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDAO {

	GetConnection gc ; 
	public UserDAO() {
		gc = new GetConnection(); 
	}
	
	public boolean insertUser(User user) {
		String sql="insert into users(name, email,password ,gender, rating) values (?,?,?,?,?)"; 
		
		try {
			gc.ps = GetConnection.getPostGressConn().prepareStatement(sql);
			gc.ps.setString(1, user.getUserName());
			gc.ps.setString(2, user.getEmail());
			gc.ps.setString(3, user.getPassword());
			gc.ps.setString(4, user.getGender());
			gc.ps.setDouble(5, user.getRating());
			
			return gc.ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				gc.ps.close();
				gc.rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public User getUser(int id) {
		String sql="select (name, email,password ,gender, rating) from emp where id=?"; 
		try {
			gc.ps = GetConnection.getPostGressConn().prepareStatement(sql); 
			gc.ps.setInt(1, id);
			
			gc.rs = gc.ps.executeQuery(); 
			if(gc.rs.next()) {
				User user = new User(id,gc.rs.getString(1),gc.rs.getString(2),gc.rs.getString(3),gc.rs.getString(4),gc.rs.getDouble(5),null);
				return user;
			}else {
				log.info("Record Not Found for " + id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				gc.ps.close();
				gc.rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
//
//	public List<User> getAllEmps() {
//		String sql ="select empid, empname, empsal from emp";
//		
//		try {
//			gc.ps = GetConnection.getPostGressConn().prepareStatement(sql);
//			List<User> list = new ArrayList<User>();
//			
//			gc.rs = gc.ps.executeQuery(); 
//			while(gc.rs.next()) {
//				User emp = new User(); 
//				emp.setId(gc.rs.getInt(1));
//				emp.setName(gc.rs.getString(2));
////				emp.setEmail(gc.rs.getDouble(3));
//				list.add(emp); 
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				gc.ps.close();
//				gc.rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return null;
//	}
	
}