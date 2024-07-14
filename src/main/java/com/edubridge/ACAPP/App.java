package com.edubridge.ACAPP;

import java.util.List;
import java.util.Scanner;

import com.edubridge.ACAPP.dao.ACDao;
import com.edubridge.ACAPP.dao.ACDaoImpl;
import com.edubridge.ACAPP.model1.AC;



public class App 
{
    public static void main( String[] args )
    {
    	ACDao dao= new ACDaoImpl();
    	Scanner in=new Scanner(System.in);
    	while(true) {
    		System.out.println("AC APP");
    		System.out.println("------");
    		System.out.println("1.ADD AC_DETAILS");
    		System.out.println("2.VIEW ALL AC_DETAILS");
    		System.out.println("3.SEARCH AC_DETAIL");
    		System.out.println("4.UPDATE AC_DETAILS");
    		System.out.println("5.DELETE AC_DETAILS");
    		System.out.println("6.DELETE ALL AC_DETAILS");
    		System.out.println("0. EXIT");
    		System.out.println("PLEASE CHOOSE OPTION:");
    		
    		int option =in.nextInt();
    		switch (option) {
			case 1:
				System.out.println("Please enter AC Brand:");
				String brand=in.next();
				
				System.out.println("Please enter AC Price:");
				Double price=in.nextDouble();
				
				System.out.println("Please enter AC Rating:");
				float rating=in.nextFloat();
				
				System.out.println("Please enter AC Warranty:");
				String warranty=in.next();
				
				AC new_AC_DETAILS=new AC();
				new_AC_DETAILS.setBrand(brand);
				new_AC_DETAILS.setPrice(price);
				new_AC_DETAILS.setRating(rating);
				new_AC_DETAILS.setWarranty(warranty);
				
				int status=dao.add_AC_Details(new_AC_DETAILS);
				if(status>=1) {
					System.out.println("New Details  are Saved!!!");
				}else {
					System.out.println("Given Details are not saved!!!");
				}
				break;
			case 2:
				List<AC> aclist=dao.get_All_AC_Details();
				if(aclist.size() !=0) {
					for(AC ac : aclist) {
						System.out.println(ac.getModelno()+"\t"+ac.getBrand()+"\t"+ac.getPrice()
						+"\t"+ac.getRating()+"\t"+ac.getWarranty());
					}
				}else {
					System.out.println("No Details are Found");
				}
				break;
			case 3:
				 System.out.println("Please enter the name of the AC Brand to search:");
                 String searchName = in.next();
                 AC ac = (AC) dao.get_AC_Details(searchName);
                 if (ac !=null) {
                     System.out.println(ac.getModelno() + "\t" + ac.getBrand() + "\t" + ac.getPrice() + "\t" + ac.getRating()+"\t"+ac.getWarranty());
                 } else {
                     System.out.println("Brand Details are  not found");
                 }
				break;
			 case 4:
                 System.out.println("Please enter the Modelno of the AC_Brand to update:");
                 int Modelno = in.nextInt();
                 
                 if (!dao.checkModelExists(Modelno)) {
                     System.out.println("There is no existing details!!!");
                 } else {

                 System.out.println("Please enter new AC Brand:");
                 String newBrand = in.next();

                 System.out.println("Please enter new AC Price:");
                 double newPrice = in.nextDouble();

                 System.out.println("Please enter new AC Rating:");
                 float newRating = in.nextFloat();
                 
                 System.out.println("Please enter new AC Warranty:");
 			     String newwarranty=in.next();

                 AC a1= new AC();
                 a1.setModelno(Modelno);
                 a1.setBrand(newBrand);
                 a1.setPrice(newPrice);
                 a1.setRating(newRating);
                 a1.setWarranty(newwarranty);

                 int Status = dao.update_AC_Details(a1);
                 if (Status >= 1) {
                     System.out.println("AC Details are Updated!!!");
                     System.out.println("-------------------------");
                     System.out.println(a1.getModelno()+"\t"+a1.getBrand()+"\t"+a1.getPrice()
						+"\t"+a1.getRating()+"\t"+a1.getWarranty());
                 }else {
                	 
                     System.out.println("Failed to update the details!!!");
                 }
                 }
                 break;
			 case 5:
                 System.out.println("Please enter the brand of the AC to delete:");
                 String dbrand = in.next();
                 int dStatus = dao.delete_AC_Details(dbrand);
                 if (dStatus >= 1) {
                     System.out.println("AC Details are Deleted!!!");
                 } else {
                     System.out.println("There is no such AC brand to delete!!!");
                 }
                 break;
			 case 6:
                 dao.delete_All_AC_Details();
                 System.out.println("All AC Details are Deleted!!!");
                 break;
			case 0:
				System.out.println("Byee!!!");
				in.close();
				System.exit(0);

			default:
				System.out.println("Invalide Option!!!!");
				break;
			}
    	}
    
    }
    }
