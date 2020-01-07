package utility_Files;
        
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    public class ExcelUtils {
                private static XSSFSheet ExcelWSheet;
                private static XSSFWorkbook ExcelWBook;
                private static XSSFCell Cell;
                private static XSSFRow Row;
            //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
            public static void setExcelFile(String Path,String SheetName) throws Exception 
            {
                   try {
                       // Open the Excel file
                    FileInputStream ExcelFile = new FileInputStream(Path);
                    // Access the required test data sheet
                    ExcelWBook = new XSSFWorkbook(ExcelFile);
                    ExcelWSheet = ExcelWBook.getSheet(SheetName);
                   // Log.info("Excel sheet opened");
                    } catch (Exception e){
                        throw (e);
                    }
            }
            //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
            public static String getCellData(int RowNum, int ColNum) throws Exception
            {
                   try{
                	  // System.out.println("Row Number ---  " + RowNum);
                	   //System.out.println("col Number ---  " + ColNum);
                	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                      String CellData = Cell.getStringCellValue();
                     // System.out.println("Celldata==="+CellData);
                      return CellData;
                      }catch (Exception e){
                        return"";
                      }
            }
            //This method is to write in the Excel cell, Row num and Col num are the parameters
           
		
			
			public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception    {
                   try{
                	   XSSFCellStyle style = ExcelWBook.createCellStyle();
                      Row  = ExcelWSheet.getRow(RowNum);
                    Cell = Row.getCell(ColNum,org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
                    if (Cell == null) {
                        Cell = Row.createCell(ColNum);
                        if(Result.equalsIgnoreCase("FAIL"))
                        {setColor(243, 246, 96,Cell,style);}
                        if(Result.equalsIgnoreCase("PASS"))
                        {setColor(71, 133, 239,Cell,style);}
                        
                        Cell.setCellValue(Result);
                        } else {
                            Cell.setCellValue(Result);
                        }
          // Constant variables Test Data path and Test Data file name
                          FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
                          ExcelWBook.write(fileOut);
                          fileOut.flush();
                        fileOut.close();
                        }catch(Exception e){
                            throw (e);
                    }
                   
                   }


			private static void setColor(int i, int j, int k, XSSFCell cell2, XSSFCellStyle style) {
				// TODO Auto-generated method stub
        		 XSSFColor myColor = new XSSFColor(Color.getHSBColor(i,j,k));
       		    style.setFillForegroundColor(myColor);
       		    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
       		    Cell.setCellStyle(style);
			}
			public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
        		int i;
        		try {
        			System.out.println(sTestCaseName);
        			System.out.println("getrowContains fun col no  " + colNum);
        			int rowCount = ExcelUtils.getRowUsed();
        			for ( i=1; i<=rowCount; i++){
        				if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
        					break;
        				}
        			}
        			return i;
        				}catch (Exception e){
        			//Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
        			throw(e);
        			}
        		}
        	
        	public static int getRowUsed() throws Exception {
        		try{
        			int RowCount = ExcelWSheet.getLastRowNum();
        			System.out.println("Total number of Row used return as < " + RowCount + " >.");	
        			//Log.info("Total number of Row used return as < " + RowCount + " >.");		
        			return RowCount;
        		}catch (Exception e){
        			//Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : "+e.getMessage());
        			//System.out.println(e.getMessage());
        			throw (e);
        		}

        	}
    }