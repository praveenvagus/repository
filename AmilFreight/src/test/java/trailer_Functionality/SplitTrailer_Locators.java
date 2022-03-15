package trailer_Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility_Files.BaseClass;

public class SplitTrailer_Locators extends BaseClass {

	public SplitTrailer_Locators(WebDriver driver) {
		super(driver);
		}

private static WebElement element = null;
	
	//To get the Account Name
	public static WebElement SplitTrailer_AccountName() throws Exception{
	    try{ 
	    	 element = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[1]/span"));
	       }catch (Exception e){
	   		System.out.println("SplitTrailer_AccountName not available");
	   		throw(e);
	   		}
	   	return element;
	}
		
	//Add Trailer
	public static WebElement SplitTrailer_TrailerAdd() throws Exception{
	    try{ 
	    	 element = driver.findElement(By.xpath("//a[@ng-click='ShowTrailerListAdd()']"));
	       }catch (Exception e){
	   		System.out.println("SplitTrailer_TrailerAdd not available");
	   		throw(e);
	   		}
	   	return element;
	}
	
	//In Side Add Trailer
		public static WebElement SplitTrailer_IN_TrailerAdd() throws Exception{
		    try{ 
		    	 element = driver.findElement(By.xpath("//*[@id='ADD']"));
		       }catch (Exception e){
		   		System.out.println("SplitTrailer_IN_TrailerAdd not available");
		   		throw(e);
		   		}
		   	return element;
		}
	
		//In Side Trailer Options
		public static WebElement SplitTrailer_IN_TrailerType_DD() throws Exception{
		   try{ 
		    	 element = driver.findElement(By.xpath("//*[@id='edittrailers']"));
		       }catch (Exception e){
		   		System.out.println("SplitTrailer_IN_TrailerType_DD not available");
		   		throw(e);
		   		}
		   	return element;
		}
			
		//In Side Trailer Options
		public static WebElement SplitTrailer_IN_TrailerNO() throws Exception{
			try{ 
				  element = driver.findElement(By.xpath("//*[@id='TrailerNo']"));
			}catch (Exception e){
			System.out.println("SplitTrailer_IN_TrailerNO not available");
		    throw(e);
		  }
		return element;
	}
		
		//Trailer No
		public static WebElement SplitTrailer_IN_TrailerVinNO() throws Exception{
			try{ 
				  element = driver.findElement(By.xpath("//*[@id='VinNo']"));
			}catch (Exception e){
			System.out.println("SplitTrailer_IN_TrailerVinNO not available");
		    throw(e);
		  }
		return element;
	}
		
		//Submit
		public static WebElement SplitTrailer_IN_TrailerSubmit() throws Exception{
			try{ 
				  element = driver.findElement(By.xpath("//button[@ng-click='SaveTrailer(COMPANYGuid)']"));
			}catch (Exception e){
			System.out.println("SplitTrailer_IN_TrailerSubmit not available");
		    throw(e);
		  }
		return element;
	}
		
		//#########################    Amil Carrier Navigation ###########################
		
		//*********************Trailer Tab ********
		public static WebElement SplitTrailer_AmilTrailerTab() throws Exception{
			try{ 
				  element = driver.findElement(By.xpath("//a[@ng-click='ShowprofileTrailerDetail(companydetail);']"));
			}catch (Exception e){
			System.out.println("SplitTrailer_AmilTrailerTab not available");
		    throw(e);
		  }
		return element;
	}
		
	//*********************Add Trailer Action*******************
		public static WebElement SplitTrailer_AmilAddTrailer() throws Exception{
			try{ 
				  element = driver.findElement(By.xpath("//*[@id='PictAdd']"));
			}catch (Exception e){
			System.out.println("SplitTrailer_AmilAddTrailer not available");
		    throw(e);
		  }
		return element;
	}			
				
		//*********************Add Trailer Option*******************
		public static WebElement SplitTrailer_AmilTrailerOptions() throws Exception{
			try{ 
					element = driver.findElement(By.xpath("//*[@id='edittrailers']"));
			}catch (Exception e){
			System.out.println("SplitTrailer_AmilTrailerOptions not available");
			throw(e);
		}
	  return element;
   }	
		
		
		
		//***************Shipment Details page navigation***********************
		public static WebElement Trailer_EDMS() throws Exception{
			try{ 
				  element = driver.findElement(By.xpath("//a[@ng-click='editTrailerName()']"));
			}catch (Exception e){
			System.out.println("Trailer_EDMS not available");
		    throw(e);
		  }
		return element;
	}
		
		public static WebElement AddTrailer_EDMS() throws Exception{
			try{ 
				  element = driver.findElement(By.xpath("//span[@ng-click='ShowAddTrailerToggle()']"));
			}catch (Exception e){
			System.out.println("AddTrailer_EDMS not available");
		    throw(e);
		  }
		return element;
	}
		
		public static WebElement EditTrailer_EDMS() throws Exception{
			try{ 
				  element = driver.findElement(By.xpath("//a[@ng-click='editTrailerName()']"));
			}catch (Exception e){
			System.out.println("Trailer_EDMS not available");
		    throw(e);
		  }
		return element;
	}
		
		
		
		
		
		
		
		
		//***************Book Now Page***********************
		//Carrier List
	   public static WebElement BookNow_CarrierName() throws Exception{
		 try{ 
		    element = driver.findElement(By.xpath("//*[@id='carrier']"));
			}catch (Exception e){
			System.out.println("BookNow_CarrierName not available");
			throw(e);
			}
		return element;
	}
	   public static WebElement BookNow_Trailer() throws Exception{
			 try{ 
				 element = driver.findElement(By.xpath("//*[@id='ddltrailerid']"));
//			    element = driver.findElement(By.xpath("//*[@id='ddltrailerid_chosen']"));
				}catch (Exception e){
				System.out.println("BookNow_Trailer not available");
				throw(e);
				}
			return element;
		}
		

	 //In Side Trailer No
	 		public static WebElement AmilSplitTrailer_IN_TrailerNO() throws Exception{
	 			try{ 
	 				  element = driver.findElement(By.xpath("//*[@id='TrailerNo']"));
	 			}catch (Exception e){
	 			System.out.println("AmilSplitTrailer_IN_TrailerNO not available");
	 		    throw(e);
	 		  }
	 		return element;
	 	}
	 		
	 		//Trailer Vin No
	 		public static WebElement AmilSplitTrailer_IN_TrailerVinNO() throws Exception{
	 			try{ 
	 				  element = driver.findElement(By.xpath("//*[@id='VinNo']"));
	 			}catch (Exception e){
	 			System.out.println("AmilSplitTrailer_IN_TrailerVinNO not available");
	 		    throw(e);
	 		  }
	 		return element;
	 	}
	 		
	 		//Submit
	 		public static WebElement AmilSplitTrailer_IN_TrailerSubmit() throws Exception{
	 			try{ 
	 				  element = driver.findElement(By.xpath("//button[@ng-click='SaveTrailer(COMPANYGuid)']"));
	 			}catch (Exception e){
	 			System.out.println("AmilSplitTrailer_IN_TrailerSubmit not available");
	 		    throw(e);
	 		  }
	 		return element;
	 	}



	 		//EDMS
			
			//*********************Add Trailer Option*******************
			public static WebElement SplitTrailer_EDMSTrailerOptions() throws Exception{
				try{ 
						element = driver.findElement(By.xpath("//*[@id='edittrailers']"));
				}catch (Exception e){
				System.out.println("SplitTrailer_EDMSTrailerOptions not available");
				throw(e);
			}
		  return element;
	   }	
			
			 //In Side Trailer No
	 		public static WebElement EDMSSplitTrailer_IN_TrailerNO() throws Exception{
	 			try{ 
	 				  element = driver.findElement(By.xpath("//*[@id='TrailerNo']"));
	 			}catch (Exception e){
	 			System.out.println("EDMSSplitTrailer_IN_TrailerNO not available");
	 		    throw(e);
	 		  }
	 		return element;
	 	}
	 		
	 		//Trailer Vin No
	 		public static WebElement EDMSSplitTrailer_IN_TrailerVinNO() throws Exception{
	 			try{ 
	 				  element = driver.findElement(By.xpath("//*[@id='VinNo']"));
	 			}catch (Exception e){
	 			System.out.println("EDMSSplitTrailer_IN_TrailerVinNO not available");
	 		    throw(e);
	 		  }
	 		return element;
	 	}
	 		
	 		//Submit
	 		public static WebElement EDMSSplitTrailer_IN_TrailerSubmit() throws Exception{
	 			try{ 
	 				  element = driver.findElement(By.xpath("//button[@ng-click='SaveTrailer(COMPANYGuid)']"));
	 			}catch (Exception e){
	 			System.out.println("EDMSSplitTrailer_IN_TrailerSubmit not available");
	 		    throw(e);
	 		  }
	 		return element;
	 	}

			
//BookNow
	 		
	 		public static WebElement BookNowSplitTrailer_AddTrailer() throws Exception{
	 			try{ 
	 				  element = driver.findElement(By.xpath("//i[@ng-click='EditTrailerdetailstemp()']"));
	 			}catch (Exception e){
	 			System.out.println("BookNowSplitTrailer_AddTrailer not available");
	 		    throw(e);
	 		  }
	 		return element;
	 	}
	 		public static WebElement SplitTrailer_BookNowTrailerOptions() throws Exception{
				try{ 
						element = driver.findElement(By.xpath("//*[@id='edittrailers']"));
				}catch (Exception e){
				System.out.println("SplitTrailer_BookNowTrailerOptions not available");
				throw(e);
			}
		  return element;
	   }	
			
			 //In Side Trailer No
	 		public static WebElement BookNowSplitTrailer_IN_TrailerNO() throws Exception{
	 			try{ 
	 				  element = driver.findElement(By.xpath("//*[@id='TrailerNo']"));
	 			}catch (Exception e){
	 			System.out.println("BookNowSplitTrailer_IN_TrailerNO not available");
	 		    throw(e);
	 		  }
	 		return element;
	 	}
	 		
	 		//Trailer Vin No
	 		public static WebElement BookNowSplitTrailer_IN_TrailerVinNO() throws Exception{
	 			try{ 
	 				  element = driver.findElement(By.xpath("//*[@id='VinNo']"));
	 			}catch (Exception e){
	 			System.out.println("BookNowSplitTrailer_IN_TrailerVinNO not available");
	 		    throw(e);
	 		  }
	 		return element;
	 	}
	 		
	 		//Submit
	 		public static WebElement BookNowSplitTrailer_IN_TrailerSubmit() throws Exception{
	 			try{ 
	 				  element = driver.findElement(By.xpath("//button[@ng-click='SaveTrailer(COMPANYGuid)']"));
	 			}catch (Exception e){
	 			System.out.println("BookNowSplitTrailer_IN_TrailerSubmit not available");
	 		    throw(e);
	 		  }
	 		return element;
	 	}

}
