package drivendata;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class practice {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\SEDHU\\OneDrive - Capgemini\\Documents\\Rahul_shetty_selenium\\Book1.xlsx");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        int sheetcount = xssfWorkbook.getNumberOfSheets();
        for(int i=0;i<sheetcount;i++){
           if( xssfWorkbook.getSheetName(i).equalsIgnoreCase("main")){
              Sheet worksheet = xssfWorkbook.getSheetAt(i);
             Iterator<Row> rows = worksheet.iterator();
             Row firstrow = rows.next();
             Iterator<Cell> it = firstrow.cellIterator();
             int j =0;
             int columnNumber =0;
             while (it.hasNext()){
                if( it.next().getStringCellValue().equalsIgnoreCase("data2")){
                    columnNumber=j;
                }
                 j++;
             }
             System.out.println(columnNumber);
             while(rows.hasNext()){
                 Row r = rows.next();
                 if(r.getCell(columnNumber).getStringCellValue().equalsIgnoreCase("haema")){
                    Iterator<Cell> cellToFind =  r.cellIterator();
                    while (cellToFind.hasNext()){
                        System.out.println(cellToFind.next());
                    }
                 }
             }
           }
        }
    }
}
