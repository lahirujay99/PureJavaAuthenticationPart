package com.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBUtil {
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	private static boolean isSuccess = false;
	private static int convertID;
	
	public static boolean validate(String username,String password){
		try {
			
			con = DBCon.getConnection();
			st = con.createStatement();
			String sql = "select * from customer where username = '"+username+"' and password = '"+password+"'";
			rs = st.executeQuery(sql);
			if(rs.next())
				isSuccess = true;
		}catch(Exception e) {
			System.out.println("error in validation phase"+e.getMessage());
		}
		
		return isSuccess;
	}
	
	public static List<Customer> getCustomer(String username){
		ArrayList<Customer> cusDetails = new ArrayList<>();
		
		try {
			con = DBCon.getConnection();
			st = con.createStatement();
			String sql = "select * from customer where username='"+username+"'";
			rs = st.executeQuery(sql);
			if(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String uname = rs.getString(5);
				String upass = rs.getString(6);
				Customer cus = new Customer(id,name,email,phone,uname,upass);
				cusDetails.add(cus);
			}
		}catch(Exception ex) {
			System.out.println("getting customer data failed! "+ex.getMessage());
		}
		
		return cusDetails;
	}
	
	public static boolean addUser(String name,String email,String phone,String username,String password) {
		try {
			con = DBCon.getConnection();
			st = con.createStatement();
			String sql = "insert into `customer`"
					+ "values(0,'"+name+"','"+email+"','"+phone+"','"+username+"','"+password+"')";
			int rs = st.executeUpdate(sql);
			if(rs>0)
				isSuccess = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return isSuccess;
	}
	
	public static boolean updateCustomer(String id,String name,String email,String phone,String username,String password){
		try {
			con = DBCon.getConnection();
			st = con.createStatement();
			String sql = "update customer "
					+ "set name='"+name+"',email='"+email+"',phone='"+phone+"',username='"+username+"',password='"+password+"'"
							+ "where id='"+id+"'";
			int rs = st.executeUpdate(sql);
			if(rs>0)
				isSuccess = true;
				
		}catch(Exception ex) {
			System.out.println("update failed"+ex.getMessage());
		}
		
		return isSuccess;
	}
	public static List<Customer> getCustomerDetails(String id){
		ArrayList<Customer> cusList = new ArrayList<>();
		convertID = Integer.parseInt(id);
		try {
			con = DBCon.getConnection();
			st = con.createStatement();
			String sql = "select * from customer where id='"+convertID+"'";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int uid = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				Customer customer = new Customer(uid,name,email,phone,username,password);
				cusList.add(customer);
			}
		}catch(Exception ex) {
			System.out.println("getting customer details failed"+ex.getMessage());
		}
		
		return cusList;
	}
	public static boolean deleteCustomer(String id) {
		convertID = Integer.parseInt(id);
		try {
			con = DBCon.getConnection();
			st = con.createStatement();
			String sql = "delete from customer where id = '"+convertID+"'";
			int rs = st.executeUpdate(sql);
			if(rs>0)
				isSuccess = true;
			
		}catch(Exception ex) {
			System.out.println("failed delete user data"+ex.getMessage());
		}
		
		return isSuccess;
	}
}
