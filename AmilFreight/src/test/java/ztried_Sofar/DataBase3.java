package ztried_Sofar;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class DataBase3 {
	
int DBValue;
@Test
public void gettingvaluecategory() throws ClassNotFoundException{

String dbURL = "jdbc:sqlserver://192.168.3.240;instance=SQLEXPRESS;"+"databaseName=AmilTruck-3.1;";
String user = "AmilTruckPreProduction";
String password = "@m!lFr3ightpro";

try {
Connection conn = DriverManager.getConnection(dbURL, user, password);
CallableStatement statement = conn.prepareCall(" [GEN].[USP_CarrierDashboard_testing]@usr_email='texoil.dispatch@gmail.com',@tabtype='2' ");

boolean hadResults = statement.execute();
int i =0;
while (hadResults) {
ResultSet resultSet = statement.getResultSet();

if(i==1) {
while (resultSet.next()) {
String title = resultSet.getString("SHP_ID");
System.out.println(title);
}
}
i=i+1;
hadResults = statement.getMoreResults();
}
statement.close();
} catch (SQLException ex) {
ex.printStackTrace();
}
}
}