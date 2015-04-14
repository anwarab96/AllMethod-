package Method;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


import java.io.FileOutputStream;


public class Excel extends LinkList{
    public static void main(String[]args){
        Workbook workbook =  new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
//        Row row = sheet.createRow(1);
//        Cell cell = row.createCell(4);
        Cell cell = sheet.createRow(0).createCell(3);
        cell.setCellValue("Hi there");


        try {
            FileOutputStream outputStream = new FileOutputStream("Test1.xls");
            workbook.write(outputStream);
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
