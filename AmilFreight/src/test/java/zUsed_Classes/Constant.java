package zUsed_Classes;

public class Constant {
	
		public static final String URLD="http://stage.amilfreight.com/";
		public static final String ChromeDriver="webdriver.chrome.driver";
		public static final String ChromeDriver_Path=(System.getProperty("user.dir") +"/drivers/chromedriver.exe");
		public static final String Amil_UserName="admin@ebintl.com";
		public static final String Amil_Password="Admin@123";
		public static final String lo4j="log4j.xml";
		public static final String Path_TestData = (System.getProperty("user.dir") +"/src/test/resources/");
		public static final String File_TestData = "TestData.xlsx";
		public static final String Path_ScreenShot = (System.getProperty("user.dir") +"/Screenshots/");
		//(System.getProperty("user.dir") +"/drivers/chromedriver.exe")
		
		//Test Data Mail Receipents
		public static final int MailRecep_TestCaseName =0;
		public static final int MailRecep_ShipperName =1;
		public static final int MailRecep_Trailer_Type =2;
		public static final int MailRecep_Dispatch_Exec =3;
		public static final int MailRecep_Pickup_Location =4;
		public static final int MailRecep_Delievery_loc =5;		
		public static final int MailRecep_ShipMentID=6;
		public static final int MailRecep_Shipment_GUID=7;
		public static final int MailRecep_CarrierAll_Name=8;
		public static final int MailRecep_CarrierAll_Mail=9;
		public static final int MailRecep_CarrierIDAll_GUID=10;
		public static final int MailRecep_CarrierSel_Name=11;
		public static final int MailRecep_CarrierSel_Mail=12;
		public static final int MailRecep_CarrierIDSel_GUID=13;
		public static final int MailRecep_QuoteAmount$=14;
		public static final int MailRecep_LoadResult =15;
		
		//Test Data SelectMail
		public static final int AllMail_TestCaseName =0;
		public static final int AllMail_ShipperName =1;
		public static final int AllMail_Pickup_Location =2;
		public static final int AllMail_Delievery_loc =3;
		public static final int AllMail_ShipMentID=4;
		public static final int AllMail_Shipment_GUID=5;
		public static final int AllMail_CarByNear_Name=6;
		public static final int AllMail_CarByNear_Mail=7;
		public static final int AllMail_CarByNear_GUID=8;
		public static final int AllMail_CarByFreq_Name=9;
		public static final int AllMail_CarByFreq_Mail=10;
		public static final int AllMail_CarByFreq_GUID=11;
		public static final int AllMail_CarPreLan_Name=12;
		public static final int AllMail_CarPreLan_Mail=13;
		public static final int AllMail_CarPreLan_GUID=14;
		public static final int AllMail_CarOrgHom_Name=15;
		public static final int AllMail_CarOrgHom_Mail=16;
		public static final int AllMail_CarOrgHom_GUID=17;
		public static final int AllMail_CarDesHom_Name=18;
		public static final int AllMail_CarDesHom_Mail=19;
		public static final int AllMail_CarDesHom_GUID=20;
		public static final int AllMail_CarPreOrg_Name=21;
		public static final int AllMail_CarPreOrg_Mail=22;
		public static final int AllMail_CarPreOrg_GUID=23;
		public static final int AllMail_CarPreDest_Name=24;
		public static final int AllMail_CarPreDest_Mail=25;
		public static final int AllMail_CarPreDest_GUID=26;
		public static final int AllMail_CarPreState_Name=27;
		public static final int AllMail_CarPreState_Mail=28;
		public static final int AllMail_CarPreState_GUID=29;
		public static final int AllMail_QuoteAmount$=30;
		public static final int AllMail_LoadResult =31;

		
	
		
		//Test Data Carrier_SignUp
		public static final int CarrierSign_TestCaseName =0;
		public static final int CarrierSign_DotNumber =1;
		public static final int CarrierSign_CarrierName =2;
		public static final int CarrierSign_MCnumber =3;
		public static final int CarrierSign_Address =4;
		public static final int CarrierSign_HomeCity =5;
		public static final int CarrierSign_HomeState =6;
		public static final int CarrierSign_ZipCode =7;
		public static final int CarrierSign_PrimName =8;
		public static final int CarrierSign_PrimRole =9;
		public static final int CarrierSign_PrimPhone =10;
		public static final int CarrierSign_PrimExtension =11;
		public static final int CarrierSign_PrimPhtype=12;
		public static final int CarrierSign_PrimEmail =13;
		public static final int CarrierSign_TractCount =14;
		public static final int CarrierSign_DriverCount =15;
		public static final int CarrierSign_Result =16;
			
		//Test Data Shipper Add
		public static final int ShipperAdd_TestCaseName =0;
		public static final int ShipperAdd_Shipper_Name =1;
		public static final int ShipperAdd_Address =2;
		public static final int ShipperAdd_City_State =3;
		public static final int ShipperAdd_Zip_Code =4;
		public static final int ShipperAdd_Contact_Name =5;
		public static final int ShipperAdd_Contact_Email =6;
		public static final int ShipperAdd_Contact_No =7;
		public static final int ShipperAdd_Sales_Rep =8;
		public static final int ShipperAdd_Sales_Rep_Mobile =9;
		public static final int ShipperAdd_Sales_Rep_Extention =10;
		public static final int ShipperAdd_Result=11;
		
		//Test Data Shipper Add
		public static final int ShipperAdd2_TestCaseName =0;
		public static final int ShipperAdd2_Shipper_Name =1;
		public static final int ShipperAdd2_Address =2;
		public static final int ShipperAdd2_City_State =3;
		public static final int ShipperAdd2_Zip_Code =4;
		public static final int ShipperAdd2_Contact_Name =5;
		public static final int ShipperAdd2_Contact_Email =6;
		public static final int ShipperAdd2_Contact_No =7;
		public static final int ShipperAdd2_Sales_Rep =8;
		public static final int ShipperAdd2_Sales_Rep_Mobile =9;
		public static final int ShipperAdd2_Sales_Rep_Extention =10;
		public static final int ShipperAdd3_Address =11;
		public static final int ShipperAdd3_City_State =12;
		public static final int ShipperAdd3_Contact_Name =13;
		public static final int ShipperAdd3_Contact_Email =14;
		public static final int ShipperAdd3_Contact_No =15;
		public static final int ShipperAdd3_Result =16;		
		
		//Test Data CRM Accounts
		public static final int ShipCRMAcc_TestCaseName =0;
		public static final int ShipCRMAcc_ShipperName =1;
		public static final int ShipCRMAcc_Address =2;
		public static final int ShipCRMAcc_CityState =3;
		public static final int ShipCRMAcc_Industry =4;
		public static final int ShipCRMAcc_Product =5;
		public static final int ShipCRMAcc_AvgLoad =6;
		public static final int ShipCRMAcc_Trailer =7;
		public static final int ShipCRMAcc_Sales1Rep =8;
		public static final int ShipCRMAcc_Sales2Rep =9;
		public static final int ShipCRMAcc_ContrType =10;
		public static final int ShipCRMAcc_Origin =11;
		public static final int ShipCRMAcc_Destination =12;
		public static final int ShipCRMAcc_TypeTrailer =13;
		public static final int ShipCRMAcc_ContactName =14;
		public static final int ShipCRMAcc_JobTitle =15;
		public static final int ShipCRMAcc_MobileNo =16;
		public static final int ShipCRMAcc_Extension =17;
		public static final int ShipCRMAcc_MobileType =18;
		public static final int ShipCRMAcc_ContEmail =19;
		public static final int ShipCRMAcc_Result =20;
		
		
		
		
		
		
		
		
		
		
		
		
	}
