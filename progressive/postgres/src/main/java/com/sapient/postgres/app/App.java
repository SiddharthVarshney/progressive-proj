package com.sapient.postgres.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sapient.postgres.beans.User;
import com.sapient.postgres.dao.UserDAO;
import com.sapient.postgres.utils.GetConnection;

//import jdk.internal.jline.internal.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */
@Slf4j
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Connection conn = GetConnection.getPostGressConn();
        System.out.println(conn);
		
//		List<User> list = null;
//		try {
//			
//			String sql1 = "SELECT * FROM users";
//			GetConnection gc = new GetConnection();
//			gc.ps = GetConnection.getPostGressConn().prepareStatement(sql1);
//			list = new ArrayList<User>();
//			
//			gc.rs = gc.ps.executeQuery(); 
//			while(gc.rs.next()) {
//				User emp = new User(); 
//				emp.setUserId(gc.rs.getInt(1));
//				emp.setUserName(gc.rs.getString(2));
//				list.add(emp); 
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		for(User u:list) System.out.println(u);
//		
        
//        User user = new User(100, "user", "email2@email.com", "pass", "male", (double) 152, LocalDate.now());
//        System.out.println(user.toString());
        User user = new User();
        user.setEmail("tempo");
        user.setUserName("newname");
        UserDAO dao = new UserDAO();
        dao.insertUser(user);
        
//        User returnUser = dao.getUser(1);
//        System.out.println(returnUser.toString());
    }
}
