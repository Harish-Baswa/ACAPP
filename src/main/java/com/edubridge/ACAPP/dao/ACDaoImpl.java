package com.edubridge.ACAPP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.ACAPP.model1.AC;
import com.edubridge.ACAPP.utils.DBUtils;

public class ACDaoImpl implements ACDao {

	@Override
	public int add_AC_Details(AC a) {
		String INSERT ="insert into ac(modelno,brand,price,rating,warranty) values(?,?,?,?,?)";
		Connection con=DBUtils.getConnection();
		int status=0;
		try {
			PreparedStatement ps=con.prepareStatement(INSERT);
			ps.setInt(1,a.getModelno());
			ps.setString(2,a.getBrand());
			ps.setDouble(3,a.getPrice());
			ps.setFloat(4,a.getRating());
			ps.setString(5,a.getWarranty());
			status=ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public List<AC> get_All_AC_Details() {
		String SELECT="select * from ac";
		Connection con=DBUtils.getConnection();
		List<AC> ACDetails=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(SELECT);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				AC a=new AC();
				a.setModelno(rs.getInt("modelno"));
				a.setBrand(rs.getString("brand"));
				a.setPrice(rs.getDouble("price"));
				a.setRating(rs.getFloat("rating"));
				a.setWarranty(rs.getString("warranty"));
				ACDetails.add(a);
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return ACDetails;
	}

	@Override
	public AC get_AC_Details(String brand) {
		String SELECT = "SELECT * FROM ac WHERE brand= ?";
		Connection con=DBUtils.getConnection();
		AC a1=null;
		 try {
	            PreparedStatement ps = con.prepareStatement(SELECT);
	            ps.setString(1,brand );
	            ResultSet rs = ps.executeQuery();
	            
	            if (rs.next()) {
	                a1=new AC();
	                a1.setModelno(rs.getInt("modelno"));
	                a1.setBrand(rs.getString("brand"));
	                a1.setPrice(rs.getDouble("price"));
	                a1.setRating(rs.getFloat("rating"));
	                a1.setWarranty(rs.getString("warranty"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return a1;
	}

	@Override
	public int update_AC_Details(AC a) {
		 String UPDATE = "UPDATE ac SET brand = ?, price = ?, rating = ?, warranty=? WHERE modelno = ?";
		    Connection con = DBUtils.getConnection();
		    int status = 0;
		    try {
		        PreparedStatement ps = con.prepareStatement(UPDATE);
		        ps.setString(1, a.getBrand());
		        ps.setDouble(2, a.getPrice());
		        ps.setFloat(3, a.getRating());
		        ps.setString(4, a.getWarranty());
		        ps.setInt(5, a.getModelno());
		       
		        status = ps.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		

		return status;
	}

	@Override
	public int delete_AC_Details(String brand) {
		String DELETE = "Delete from ac where brand = ?";
	    Connection con = DBUtils.getConnection();
	    int status = 0;
	    try {
	        PreparedStatement ps = con.prepareStatement(DELETE);
	        ps.setString(1, brand);
	        status = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

		return status;
	}

	@Override
	public void delete_All_AC_Details() {
		String DELETEALL = "Delete from ac";
	    Connection con = DBUtils.getConnection();
	    try {
	        PreparedStatement ps = con.prepareStatement(DELETEALL);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

		
	}

	@Override
	public boolean checkModelExists(int modelno) {
        String query = "SELECT * FROM ac WHERE modelno = ?";
        Connection con = DBUtils.getConnection();
        boolean exists = false;
        try {
        	 PreparedStatement ps= con.prepareStatement(query);
        	 ps.setInt(1,modelno);
        	 ResultSet rs=ps.executeQuery();
        	 if (rs.next()) {
                 exists = rs.getInt(1) > 0;
             }
        }catch(SQLException e) {
        	e.printStackTrace();
        } 

		return exists;
	}
	

}
	