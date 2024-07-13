package drivendata;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excel_TestNgDataprovider {
DataFormatter formatter = new DataFormatter();
    @Test(dataProvider = "datadrive")
    public void test(String s, String v,String j){
System.out.println(s+" "+v+" "+j);
    }

    @DataProvider(name ="datadrive")
    public Object[][] getDat() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\SEDHU\\OneDrive - Capgemini\\Documents\\Rahul_shetty_selenium\\Book2.xlsx");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
       XSSFSheet sheet =  xssfWorkbook.getSheetAt(0);
       int rowCount =sheet.getPhysicalNumberOfRows();
       int colCount =sheet.getRow(0).getPhysicalNumberOfCells();
       Object[][] getData = new Object[rowCount-1][colCount];
      for (int i=0;i<rowCount-1;i++){
         Row r = sheet.getRow(i+1);
         for (int j=0;j<colCount;j++){
             Cell cell = r.getCell(j);
            getData[i][j] = formatter.formatCellValue(cell);
         }
        }
return getData;
    }
}
