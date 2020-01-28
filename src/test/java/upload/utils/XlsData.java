package upload.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XlsData {

    public static final String path = "";
    private static HSSFCell region;
    private static HSSFCell model;
    private static HSSFCell yearFrom;
    private static HSSFCell yearTo;


    public static List<Map<String,String>> getValuesFromXls() {
        List<Map<String,String>> valuesFromXls = new ArrayList<Map<String, String>>();
        try {
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);

            for (int row = 6; row < 3442; row++) {
                Map<String, String> valuesPerOneRow = new HashMap<String, String>();
                region = sheet.getRow(row).getCell(0);
                valuesPerOneRow.put("region", region.getStringCellValue());
                model = sheet.getRow(row).getCell(1);
                valuesPerOneRow.put("model", model.getStringCellValue());
                yearFrom = sheet.getRow(row).getCell(2);
                valuesPerOneRow.put("yearFrom", yearFrom.getStringCellValue());
                yearTo = sheet.getRow(row).getCell(3);
                valuesPerOneRow.put("yearTo", yearTo.getStringCellValue());
                valuesFromXls.add(valuesPerOneRow);
            }

            fileInputStream.close();
            FileOutputStream out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return valuesFromXls;
    }
}
