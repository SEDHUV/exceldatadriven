package drivendata;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class simpledriven {

   public ArrayList<String> getData(String testcase) throws IOException {
       ArrayList<String> a = new ArrayList<String>();
       FileInputStream inputStream = new FileInputStream("C:\\Users\\SEDHU\\OneDrive - Capgemini\\Documents\\Rahul_shetty_selenium\\Book1.xlsx");
       XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
       int sheetcount =  xssfWorkbook.getNumberOfSheets();
       System.out.println(sheetcount);
       for (int i=0;i<sheetcount;i++){
           if(xssfWorkbook.getSheetName(i).equalsIgnoreCase("main")){
               XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
               //Scan entire first row to identify testcases column
               Iterator<Row> row =sheet.iterator();//sheet is a collection of rows
               Row  firstrow =  row.next();
               Iterator<Cell> cell = firstrow.cellIterator();//row is collection of cells
               int k=0;
               int column =0;
               while (cell.hasNext()){
                   Cell value = cell.next();
                   if(value.getStringCellValue().equalsIgnoreCase("Testcases")){
                       column =k;
                   }
                   k++;
               }
               System.out.println(column);
               //once testcases column identified go and scan all the columns to get purchase row
               while (row.hasNext()){

                   Row r =  row.next();
                   if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcase)){
                       //onmce purchase identified grab all the data in the cells and fed in our test
                       Iterator<Cell> desiredcell =  r.cellIterator();
                       while (desiredcell.hasNext()){
                           Cell c =desiredcell.next();
                           if(c.getCellType()== CellType.STRING){
                               a.add(c.getStringCellValue());
                           }else {
                               a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                           }

                       }
                   }
               }
           }


       }
       return a;
   }
}
