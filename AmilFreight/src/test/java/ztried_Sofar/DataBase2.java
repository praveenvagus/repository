package ztried_Sofar;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.testng.annotations.Test;

public class DataBase2 {
	

	int DBValue;

	@Test
	  
	  public void gettingvaluecategory() throws ClassNotFoundException{

			
	        String dbURL = "jdbc:sqlserver://192.168.3.240;instance=SQLEXPRESS;"+"databaseName=AmilTruck-2.1;";
	        String user = "AmilTruckPreProduction";
	        String password = "@m!lFr3ightpro";
	 
	        try {
	                Connection conn = DriverManager.getConnection(dbURL, user, password);
	                CallableStatement statement = conn.prepareCall(" [CONFIG].[USP_GetLoadSpecificMails_back] @Shp_guid='912fad3c-9795-49fd-b56c-38a042265fb0' ");

	 	                boolean hadResults = statement.execute();
	   	     int i =0;
	                while (hadResults) {
	                    ResultSet resultSet = statement.getResultSet();
	                   // JTable tablevalue = new JTable(buildTableModel(resultSet));
	                    // process result set
	                    
	                  //  ResultSetMetaData rsmd = resultSet.getMetaData();
	                    //int columns = rsmd.getColumnCount();
	                   // List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	                  //  while (resultSet.next()){
	                  //      Map<String, Object> row = new HashMap<String, Object>(columns);
	                 //       for(int i = 1; i <= columns; ++i){
	                  //          row.put(rsmd.getColumnName(i), resultSet.getObject(i));
	              //          }
	                //        rows.add(row);
	            //        }
	                    
	              //      boolean isResultSet =false;
	               //     resultSet = statement.getMoreResults();
	                    
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
	     
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	
	    }