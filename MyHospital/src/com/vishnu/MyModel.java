package com.vishnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyModel {
	
	public static Connection getConn() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		   
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","vishnunandan90","PLhv@123"); 
		return con;
		
		
	}
	public void addPatient(patient p) {
		Connection conn=null;
		try {
			conn = getConn();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps3= conn.prepareStatement("insert into patients values(seq_person.nextval,?,?,?,?)");
			ps3.setString(1, p.name);
			ps3.setInt(2, p.age);
			ps3.setDate(3,p.date);
			ps3.setInt(4,p.timeslot);
			ps3.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public static boolean checkTimeslot(java.sql.Date date, int timeslot) throws Exception {
		Connection conn = getConn();
		ResultSet rs = conn.createStatement().executeQuery("select * from availability");
		
		while(rs.next()) {
			if(rs.getDate(5).compareTo(date)==0) {
				conn.createStatement().execute("update availability set timeslot"+timeslot+"=1 where date = "+date );
			}
			else {
				continue;
			}
		}
		return false;
	}
	public boolean isAvailable(String date, int timeslot){
		try{  
			java.sql.Date sqdate = java.sql.Date.valueOf(date);
			 Connection con = getConn();	   
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from availability"); 
			

			PreparedStatement ps = con.prepareStatement("insert into availability values(0,0,0,0,?)");
			//PreparedStatement ps2 = con.prepareStatement("update availability set ");
			if(!rs.next()) {
				System.out.println("3");
				// availability table is empty so adding the date and assigning 0s to timeslots and call isavailable again				
				ps.setDate(1, sqdate);
				ps.execute();
				if(checkTimeslot(sqdate,timeslot))
					return true;
				else
					return false;
			}
			rs=stmt.executeQuery("select * from availability"); 
			while(rs.next()) {
				System.out.println("rowsthere");
				if(sqdate.compareTo(rs.getDate(5))==0) {
					System.out.println(rs.getDate(5));
					
					if(rs.getInt(timeslot)==0) {
						
					con.createStatement().execute("update availability set timeslot"+timeslot+"=1" );				
						return true;
					}
					else {
						//System.out.println("2");
						return false;
					}
				}
				else {
					continue;
				}
			}
			//if not returned yet it means that that date is not there yet so let us add the date			
			ps.setDate(1, sqdate);
			ps.execute();
			con.createStatement().execute("update availability set timeslot"+timeslot+"=1" );
			System.out.println("4");
			con.close();
			return true;
					
			//step5 close the connection object  
			  
			}catch(Exception e){ System.out.println(e);
			}	
		return false;	
	}
}
