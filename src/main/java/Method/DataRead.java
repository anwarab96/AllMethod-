package Method;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by salahakanda on 2/15/15.
 */
public class DataRead {

    public static int numberOfRows, numberOfColumn;

    public String[][] read(String filename) throws IOException {
        String[][] dataContainer;
        File file = new File(filename);

        FileInputStream fis = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);
        numberOfRows = sheet.getLastRowNum() + 1;
        numberOfColumn = sheet.getRow(0).getLastCellNum();
        System.out.println("Rows is " + numberOfRows);
        System.out.println("Colum is " + numberOfColumn);
        dataContainer = new String[numberOfRows][numberOfColumn];
        System.out.println(dataContainer.length);

        for (int i = 0; i < dataContainer.length; i++) {
            HSSFRow row = sheet.getRow(i);
            for (int j = 0; j < numberOfColumn; j++) {
                HSSFCell cell = row.getCell(j);
                String cellData = convertCell(cell);
                dataContainer[i][j] = cellData;
                System.out.println(cellData);


            }

        }

        return dataContainer;
    }


    public String convertCell(HSSFCell cell) {
        Object data = null;
        int dataType = cell.getCellType();
        switch (dataType) {
            case HSSFCell.CELL_TYPE_NUMERIC:
                data = cell.getNumericCellValue();
                break;
            case HSSFCell.CELL_TYPE_STRING:
                data = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                data = cell.getBooleanCellValue();
                break;
        }

        return data.toString();
    }
}
