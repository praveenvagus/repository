package zUsed_Classes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabableView;

import org.testng.annotations.Test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DataBase_QuoteResponse2 {
	

	int DBValue;
	@Test
	public void gettingvaluecategory() throws ClassNotFoundException, SQLException{
				
	String dbURL = "jdbc:sqlserver://192.168.3.240;instance=SQLEXPRESS;"+"databaseName=AmilTruck-3.1;";
	String user = "AmilTruckPreProduction";
	String password = "@m!lFr3ightpro";
		 
	Connection conn = DriverManager.getConnection(dbURL, user, password);
	CallableStatement statement = conn.prepareCall(" [CONFIG].[USP_GetLoadSpecificMails_back] @Shp_guid='912fad3c-9795-49fd-b56c-38a042265fb0' ");
	boolean hadResults = statement.execute();
	int i =0;
	while (hadResults) {
	ResultSet resultSet = statement.getResultSet();
	if(i==1) {
	while (resultSet.next()) {
	String title = resultSet.getString("toemailid");
	System.out.println(title);
	}
	}
	i=i+1;
	hadResults = statement.getMoreResults();
	}
	statement.close();
	}
	}