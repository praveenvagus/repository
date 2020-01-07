package loginPage_Validations;

public class JavaPgm_PwdValidation {
	
public static void main(String[] args) {

		
		String str="Admin@23";
		
		if(str.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")){
			
			System.out.println("Matched");
		}
		
		if(str.length()==8){
			
			System.out.println("Equal");
		}

				
	}
			

}
