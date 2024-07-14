package com.edubridge.ACAPP.dao;

import java.util.List;

import com.edubridge.ACAPP.model1.AC;

public interface  ACDao {
	   int add_AC_Details(AC a);
	   List<AC> get_All_AC_Details();
	   AC get_AC_Details(String brand);
	   int update_AC_Details(AC a);
	   int delete_AC_Details(String brand);
	   void delete_All_AC_Details();
	   boolean checkModelExists(int modelno);
	

}
