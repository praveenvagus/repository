package ztried_Sofar;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class GoogMatrixRequest{
	
public static void main(String[] ignored) throws Exception {

URLConnection connection = new URL("http://test-mapservice.amilfreight.com/maps/api/distancematrix/json?units=imperial&origins=27.667956,%2078.636093|&destinations=13.610693,%2078.320086|&key=AIzaSyA9fYVGIBv_tUzxpyN_uQLiUchx0PYTkJo").openConnection();
try(Scanner scanner = new Scanner(connection.getInputStream());){
String response = scanner.useDelimiter("\\A").next();
	  
int d =response.indexOf("distance");
String data1 = response.substring(d);
int d2 = data1.indexOf("text");
	     
String data2 =data1.substring(d2+9);
int d3=data1.indexOf('"');
String data3 =data2.substring(0,d3);
//System.out.println(response);  
//System.out.println(data3);

String intValue = data3.replaceAll("[^0-9]", "");
int miles = Integer.parseInt(intValue);
System.out.println(miles);

int c=miles	+145;
System.out.println(c);


}
	 
}  
}