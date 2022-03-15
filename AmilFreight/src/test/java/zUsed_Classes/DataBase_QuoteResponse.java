package zUsed_Classes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.testng.annotations.Test;

public class DataBase_QuoteResponse {
	

	int DBValue;
	@SuppressWarnings("unused")
	@Test
	public void gettingvaluecategory() throws ClassNotFoundException, SQLException{
				
	String dbURL = "jdbc:sqlserver://192.168.3.240;instance=SQLEXPRESS;"+"databaseName=AmilTruck-3.1;";
	String user = "AmilTruckPreProduction";
	String password = "@m!lFr3ightpro";
		 
	String usr_email="texoil.dispatch@gmail.com";
	String tabtype="1";
	Connection conn = DriverManager.getConnection(dbURL, user, password);
	//CallableStatement statement = conn.prepareCall(" [CONFIG].[USP_GetLoadSpecificMails_back] @Shp_guid='912fad3c-9795-49fd-b56c-38a042265fb0' ");
	CallableStatement statement = conn.prepareCall(" [Gen].[usp_CarrierDashboard_testing] @usr_email='texoil.dispatch@gmail.com' ");
	//statement.setString(1, "usr_email");
	//statement.setString("tabtype", "1");
	//[Gen].[usp_CarrierDashboard_testing]--@usr_email='texoil.dispatch@gmail.com',@tabtype=1
	boolean hadResults = statement.execute();
	int i =0;
	while (hadResults) {
	ResultSet resultSet = statement.getResultSet();
	if(i==1) {
	while (resultSet.next()) {
	String title = resultSet.getString("shp_id");
	System.out.println(title);
	}
	}
	i=i+1;
	hadResults = statement.getMoreResults();
	}
	statement.close();
	}
	}