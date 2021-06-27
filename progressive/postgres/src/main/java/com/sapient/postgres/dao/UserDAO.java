package com.sapient.postgres.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.sapient.postgres.beans.User;
import com.sapient.postgres.utils.GetConnection;

import antlr.collections.List;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class UserDAO {

	GetConnection gc ; 
	public UserDAO() {
		gc = new GetConnection(); 
	}
	
	public void dropUsersTable() {
		String sql="DELETE FROM users";
		try {
			gc.ps = GetConnection.getPostGressConn().prepareStatement(sql);
			
			gc.ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean insertUser(User user) {
		String sql="insert into users(userName, email,password ,gender, rating) values (?,?,?,?,?)"; 
		
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
		}
		return false;
	}

	public User getUser(int id) {
		String sql="select username, email,password ,gender, rating, createdat from users where userId=?"; 
		try {
			gc.ps = GetConnection.getPostGressConn().prepareStatement(sql); 
			gc.ps.setInt(1, id);
//			log.info(gc.ps);
			gc.rs = gc.ps.executeQuery(); 
			if(gc.rs.next()) {
				User user = new User(id,gc.rs.getString(1),gc.rs.getString(2),gc.rs.getString(3),gc.rs.getString(4),gc.rs.getDouble(5),gc.rs.getDate(6));
//				
//				user.setUserName(gc.rs.getString(1));
				
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
	
	public User getUser(String email) {
		String sql="select userid,username, email,password ,gender, rating from users where email=?"; 
		try {
			gc.ps = GetConnection.getPostGressConn().prepareStatement(sql); 
			gc.ps.setString(1, email);;
			
			gc.rs = gc.ps.executeQuery(); 
			if(gc.rs.next()) {
				User user = new User(gc.rs.getInt(1),gc.rs.getString(2),gc.rs.getString(3),gc.rs.getString(4),gc.rs.getString(5),gc.rs.getDouble(6),null);
				return user;
			}else {
				log.info("Record Not Found for " + email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

	
}