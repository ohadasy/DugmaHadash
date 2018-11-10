package com.DugmaHadash.com.service;


public class CouponsTest {
	
	
		 {
				// TODO Auto-generated method stub
			 	// create Db
			 	MySqlHandler coupondbhandler = new MySqlHandler();
			 	coupondbhandler.getConnection("127.0.0.1/", "root", "");
//			 	coupondbhandler.creatDB("couponproj1");
			 	 
			 	// create Tables
//			 	MySqlHandler coupondbhandler = new MySqlHandler();
			 	coupondbhandler.getConnection("127.0.0.1/", "root", "");		 	
			 	coupondbhandler.setDb("couponproj1");
			 	coupondbhandler.createTable("Company","ID int, COMP_NAME varchar(20),PASSWORD varchar(10),EMAIL varchar(30),PRIMARY KEY (ID)");
			 	coupondbhandler.createTable("Customers","ID int,CUST_NAME varchar(20),PASSWORD varchar(10),PRIMARY KEY (ID)");			 	
			 	coupondbhandler.createTable("Coupon","ID int,TITLE varchar(30),START_DATE date ,END_DATE date , AMOUNT int ,TYPE ENUM ('food','electric','vacation'),MESSAGE varchar(100),PRICE double,IMAGE varchar(100),PRIMARY KEY (ID)");
			 	coupondbhandler.createTable("Customer_Coupon","CUST_ID int,COUPON_ID int,PRIMARY KEY (CUST_ID,COUPON_ID),"
			 			+ "FOREIGN KEY (CUST_ID) REFERENCES Customers(ID),FOREIGN KEY (COUPON_ID) REFERENCES Coupon(ID)");
			 	coupondbhandler.createTable("Company_Coupon","COMP_ID int,COUPON_ID int,PRIMARY KEY (COMP_ID,COUPON_ID),"
			 			+ "FOREIGN KEY (COMP_ID) REFERENCES Company(ID),FOREIGN KEY (COUPON_ID) REFERENCES Coupon(ID)");
			 
			 	
//			 	CREATE TABLE Company(ID long, COMP_NAME varchar(20),PASSWORD varchar(10),ENAIL varchar(30),PRIMARY KEY (ID));
//			 	coupondbhandler.sqlAction("create TABLE `user` ( `username` VARCHAR(10) NOT NULL)");
//			 	coupondbhandler.sqlAction("ALTER TABLE users ADD ( userpassword VARCHAR(10) NOT NULL, firstmane VARCHAR(20) NOT NULL )");
			 	
//			 	coupondbhandler.sqlAction("INSERT INTO `users` (`usermame`, `userpassword`, `firstmane`) VALUES ('ofir', '123', 'har');");
//			 	coupondbhandler.sqlAction("select * from  'users' where usermame = 'ofir'");
//			 	coupondbhandler.creatDB("couponproj");

//				Users ofir = new Users("m31", "Ofir", "1234");
//				Users Moshe = new Users("m32", "Moshe", "1234");
//				Tasks mesima1 = new Tasks (1,"bdika1", "bdikat_msima1", 1, "");
//				Tasks mesima2 = new Tasks (2,"bdika2", "bdikat_msima2", 2, "");
//				Tasks mesima3 = new Tasks (3,"bdika3", "bdikat_msima3", 3, "");
//				mesima1.setUser("m31");
//				mesima2.setUser("m33");
//				ArrayList<Tasks> tasks_array = new ArrayList<Tasks>();
//				tasks_array.add(mesima1);
//				tasks_array.add(mesima2);
//				tasks_array.add(mesima3);
//				
//				for (int i = 0; i < tasks_array.size(); i++) 
//				{
//					System.out.println(tasks_array.get(i));
//				}
			 	
			
			

			}

}
