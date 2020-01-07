package locators_Amil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility_Files.BaseClass;

public class Locators_CarrieSignup extends BaseClass {

		
public Locators_CarrieSignup(WebDriver driver) {
	super(driver);
}
	private static WebElement element = null;

	    //SignupSections Link
	    public static WebElement SignupSections() throws Exception{
	     try{ 
	     
	    	 element = driver.findElement(By.xpath("//*[@id='main-nav']/div/div[2]/div[3]/div/ul/li[3]/a"));
	    	 }catch (Exception e){
	                  System.out.println("SignupSections not available");
	                  throw(e);
	                  }
	           return element;
	    }   
		
	  //SignupSection - Carrier Link
	    public static WebElement Signup_Carrier() throws Exception{
	     try{ 
	   
	    	 element =driver.findElement(By.xpath("//a[contains(@href,'/SIGN UP FREE')]"));
	    			 
	    			 //driver.findElement(By.xpath("//*[@id='main-nav']/div/div[2]/div[3]/div/ul/li[2]/ul/li[2]/a"));
	        }catch (Exception e){
	                  System.out.println("Signup_Carrier not available");
	                  throw(e);
	                  }
	           return element;
	    }
	   
	    
	  //Dot Number
	    public static WebElement DotNumber() throws Exception{
	     try{ 
	    	 
	        	 element =driver.findElement(By.id("dot"));
	        }catch (Exception e){
	                  System.out.println("DotNumber not available");
	                  throw(e);
	                  }
	           return element;
	    }
	    
	  //submit Dot Number
	    public static WebElement SubmitDotNumber() throws Exception{
	     try{ 
	    	 
	        	 element =driver.findElement(By.id("btnDOT"));
	        }catch (Exception e){
	                  System.out.println("SubmitDotNumber not available");
	                  throw(e);
	                  }
	           return element;
	    }
		
	    
	  //Navigate to the Profile Page
	    public static WebElement creationLink() throws Exception{
	     try{ 
	    	 
	    	 element =driver.findElement(By.xpath("//*[@id='CarrierSignUp']/div[1]/div/div[5]/div[2]/p[3]/a"));
	        }catch (Exception e){
	                  System.out.println("SubmitDotNumber not available");
	                  throw(e);
	                  }
	           return element;
	    }
	    
	  //*****************************Company Details*************************************
	  //Company Profile
	  //Account Name 
	    public static WebElement accountName() throws Exception{
	     try{ 
	    	 
	        	 element =driver.findElement(By.id("txtAccountName"));
	        }catch (Exception e){
	                  System.out.println("accountName not available");
	                  throw(e);
	                  }
	           return element;
	    }
	    
	    //mc Number
	    public static WebElement mcNumber() throws Exception{
	        try{ 
	       	 
	           	 element =driver.findElement(By.id("txtMC"));
	           }catch (Exception e){
	                     System.out.println("mcNumber not available");
	                     throw(e);
	                     }
	              return element;
	       }
	    
	  //Street Name    
	    public static WebElement streetName() throws Exception{
	        try{ 
	       	 
	           	 element =driver.findElement(By.id("txtstreetname"));
	           }catch (Exception e){
	                     System.out.println("streetName not available");
	                     throw(e);
	                     }
	              return element;
	       }
	  //City Name
	    public static WebElement cityName() throws Exception{
	        try{ 
	       	 
	           	 element =driver.findElement(By.id("txtNewCityName"));
	           }catch (Exception e){
	                     System.out.println("cityName not available");
	                     throw(e);
	                     }
	              return element;
	       }
	    

	  //Zip Code
	    public static WebElement zip_Code() throws Exception{
	        try{ 
	       	 
	           	 element =driver.findElement(By.id("txtStateCode"));
	           }catch (Exception e){
	                     System.out.println("zip_Code not available");
	                     throw(e);
	                     }
	              return element;
	       }
	 
	  //ContactName
	    public static WebElement Contact_Name() throws Exception{
	        try{ 
	       	 
	           	 element =driver.findElement(By.xpath("//*[@id='txtcontactname']"));
	           }catch (Exception e){
	                     System.out.println("Contact_Name not available");
	                     throw(e);
	                     }
	              return element;
	       }
	    
	    
	  //Contact Role
	    public static WebElement contactRoles() throws Exception{
	     try{ 
	    	 element =driver.findElement(By.xpath("//*[@id='Sddlcontactroles']"));
	        }catch (Exception e){
	                  System.out.println("contactRoles not available");
	                  throw(e);
	                  }
	           return element;
	    }
	    
	  //Contact Number
	    public static WebElement contactNumber() throws Exception{
	     try{ 
	    	 element =driver.findElement(By.id("txtphone"));
	        }catch (Exception e){
	                  System.out.println("contactNumber not available");
	                  throw(e);
	                  }
	           return element;
	    }
	    
	  //Extension
	    public static WebElement extension() throws Exception{
	     try{ 
	    	 element =driver.findElement(By.id("Extension"));
	        }catch (Exception e){
	                  System.out.println("extension not available");
	                  throw(e);
	                  }
	           return element;
	    }
	  //Email
	    public static WebElement email() throws Exception{
	     try{ 
	    	 element =driver.findElement(By.id("txtemail"));
	        }catch (Exception e){
	                  System.out.println("email not available");
	                  throw(e);
	                  }
	           return element;
	    }
	    //No.of Tractors
	    public static WebElement no_Tractors() throws Exception{
	     try{ 
	    	 element =driver.findElement(By.id("nooftrailers"));
	        }catch (Exception e){
	                  System.out.println("no_Tractors not available");
	                  throw(e);
	                  }
	           return element;
	    }
	    
	  //No.of Drivers
	    public static WebElement no_Drivers() throws Exception{
	     try{ 
	    	 element =driver.findElement(By.id("noofdrivers"));
	        }catch (Exception e){
	                  System.out.println("no_Drivers not available");
	                  throw(e);
	                  }
	           return element;
	    } 
	    
	    
	  //Submit Company Profile
	    public static WebElement submitDetails() throws Exception{
	     try{ 
	    	 element =driver.findElement(By.xpath("//*[@id='trailerdetails']/div[2]/a[2]"));
	        }catch (Exception e){
	                  System.out.println("submitDetails not available");
	                  throw(e);
	                  }
	           return element;
	    } 
	    
	    
	  //Lane Zone
	    public static WebElement LaneZone() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.xpath("//*[@id='zone9']"));
	           }catch (Exception e){
	                     System.out.println("LaneZone not available");
	                     throw(e);
	                     }
	              return element;
	       }
	    
	    
	    //State - Origin
	    public static WebElement State_Origin() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.id("stateorigin"));
	           }catch (Exception e){
	                     System.out.println("State_Origin not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	  //State - Destination
	    public static WebElement State_Destination() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.id("statedestination"));
	           }catch (Exception e){
	                     System.out.println("State_Destination not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	    
	  //State - Add
	    public static WebElement State_Submit() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.xpath("//*[@id='statestep']/div[1]/button"));
	           }catch (Exception e){
	                     System.out.println("State_Destination not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	    
	  //City - Origin
	    public static WebElement City_Origin() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.id("cityorigin"));
	           }catch (Exception e){
	                     System.out.println("City_Origin not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	  //City - Destination
	    public static WebElement City_Destination() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.id("citydestination"));
	           }catch (Exception e){
	                     System.out.println("City_Destination not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	    
	  //City - Add
	    public static WebElement City_Submit() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.xpath("//*[@id='citystep']/div[1]/button"));
	           }catch (Exception e){
	                     System.out.println("City_Submit not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	    
	    
	    //LanePreferrences Submit
	    public static WebElement LanePreferrences_Submit() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.xpath("//*[@id='citystep']/div[1]/button"));
	           }catch (Exception e){
	                     System.out.println("LanePreferrences_Submit not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	    
	    /*********************************Paperwork*************************************/
	    
	    public static WebElement broker_Agreement() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.id("CBAdoc"));
	       //*[@id="BrokerAgreement"]/div[1]/div[2]/div[3]/div[1]/div[2]/span/span
	           }catch (Exception e){
	                     System.out.println("broker_Agreement not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	    
	    
	    public static WebElement no_For_Factoring() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.xpath("//*[@id='lstBankInfo']/div[1]/div[2]/span[2]/input"));
	           }catch (Exception e){
	                     System.out.println("no_For_Factoring not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	    
	    public static WebElement TaxId() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.xpath("//*[@id='lstBankInfo']/div[10]/input"));
	           }catch (Exception e){
	                     System.out.println("TaxId not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	    
	    
	    
	    
	    //To Select Payment Mode
	    public static WebElement PaymentMode() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.id("ddlBankPaymentmode"));
	           }catch (Exception e){
	                     System.out.println("PaymentMode not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	    
	  //To give Bank Name
	    public static WebElement BankName() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.id("txtbankname"));
	           }catch (Exception e){
	                     System.out.println("BankName not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	    
	    public static WebElement bank_Detail_Finder() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.id("txtcontactname"));
	           }catch (Exception e){
	                     System.out.println("bank_Detail_Finder not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	    
	    //Contact Name
	    public static WebElement bank_ContactName() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.id("txtcontactname"));
	           }catch (Exception e){
	                     System.out.println("bank_ContactName not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	    //street address
	    public static WebElement BankStreet_Address() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.name("address"));
	           }catch (Exception e){
	                     System.out.println("BankStreet_Address not available");
	                     throw(e);
	                     }
	              return element;
	       } 
	 
	    //Bank City/State Name
	    public static WebElement BankCityStateName() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.name("address"));
	           }catch (Exception e){
	                     System.out.println("BankCityName not available");
	                     throw(e);
	                     }
	              return element;
	       }
	  //General liability
	    public static WebElement GLLimits() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.xpath("//*[@id='txtCGLLimits']"));
	           }catch (Exception e){
	                     System.out.println("GLLimits not available");
	                     throw(e);
	                     }
	              return element;
	       }
		//General liability Expiry
	    public static WebElement GLExpiry() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.xpath("//*[@id='dtCGLPolicyExp']"));
	           }catch (Exception e){
	                     System.out.println("GLExpiry not available");
	                     throw(e);
	                     }
	              return element;
	       }
	    
	  //Auto liability
	    public static WebElement ALLimits() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.xpath("//*[@id='txtALLimits']"));
	           }catch (Exception e){
	                     System.out.println("ALLimits not available");
	                     throw(e);
	                     }
	              return element;
	       }
		//AL Expiry
	    public static WebElement ALExpiry() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.xpath("//*[@id='dtALLimits']"));
	           }catch (Exception e){
	                     System.out.println("ALExpiry not available");
	                     throw(e);
	                     }
	              return element;
	       }
	    
	    
	    //cargo coverage   
	    public static WebElement CCLimits() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.xpath("//*[@id='txtCCLimits']"));
	           }catch (Exception e){
	                     System.out.println("CCLimits not available");
	                     throw(e);
	                     }
	              return element;
	       }
		//CC Expiry
	    public static WebElement CCExpiry() throws Exception{
	        try{ 
	       	 element =driver.findElement(By.xpath("//*[@id='insurance']/div[1]/div[1]/div[3]/div/div[2]/input"));
	           }catch (Exception e){
	                     System.out.println("CCExpiry not available");
	                     throw(e);
	                     }
	              return element;
	       }
		
	
	    
	    
	    
	    
	    
	    
	    //Workers comp
	    public static WebElement Workers_Comp() throws Exception{
		     try{ 
		    	 element =driver.findElement(By.xpath("//*[@id='txtWorkersComp']"));
		        }catch (Exception e){
		                  System.out.println("Workers_Comp not available");
		                  throw(e);
		                  }
		           return element;
		    }
	    
	    //Reefer Break Down
	    public static WebElement ReeferWorkdown() throws Exception{
		     try{ 
		    	 element =driver.findElement(By.id("Reeferbreakdown"));
		        }catch (Exception e){
		                  System.out.println("ReeferWorkdown not available");
		                  throw(e);
		                  }
		           return element;
		    }
	    
	    //*************************Document Types***********************************
	    //W-9 Document
	    public static WebElement Document_W9() throws Exception{
		     try{ 
		    	 element =driver.findElement(By.xpath("//*[@id='InsuranceDoc']"));
		        }catch (Exception e){
		                  System.out.println("Document_W9 not available");
		                  throw(e);
		                  }
		           return element;
		    }
	    
	    //Operating Authority
	    public static WebElement Document_OperatingAuthority() throws Exception{
		     try{ 
		    	 element =driver.findElement(By.xpath("//*[@id='OperatingAuth']"));
		        }catch (Exception e){
		                  System.out.println("Document_OperatingAuthority not available");
		                  throw(e);
		                  }
		           return element;
		    }
	  //Certificate Of Insurance
	    public static WebElement Document_CertificateOfInsurance() throws Exception{
		     try{ 
		    	 element =driver.findElement(By.xpath("//*[@id='CInsurance']"));
		        }catch (Exception e){
		                  System.out.println("Document_CertificateOfInsurance not available");
		                  throw(e);
		                  }
		           return element;
		    }
	  //Other
	    public static WebElement Document_Other() throws Exception{
		     try{ 
		    	 element =driver.findElement(By.xpath("//*[@id='Otherdocs']"));
		        }catch (Exception e){
		                  System.out.println("Document_Other not available");
		                  throw(e);
		                  }
		           return element;
		    }
	    
	    //term and conditions agree
	    public static WebElement IAgreeCheck() throws Exception{
		     try{ 
		    	 element =driver.findElement(By.xpath("//*[@id='check']"));
		        }catch (Exception e){
		                  System.out.println("IAgreeCheck not available");
		                  throw(e);
		                  }
		           return element;
		    }
	    

		  //Submit Paper Work
		    public static WebElement SubmitPaperWork() throws Exception{
			     try{ 
			    	 element =driver.findElement(By.xpath("//*[@id='insurance']/div[3]/button"));
			        }catch (Exception e){
			                  System.out.println("SubmitPaperWork not available");
			                  throw(e);
			                  }
			           return element;
			    }

}
