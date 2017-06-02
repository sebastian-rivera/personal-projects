package com.ellipticalcode.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by crono on 5/31/2017.
 */
public class ExcelExport {

    public static byte[] ExportToExcel(Map<String, Object[]> rows, String reportName) throws IOException {

        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet(reportName);
        //Create row object
        XSSFRow row;

        //Iterate over data and write to sheet
        Set<String> keyid = rows.keySet();
        int rowid = 0;
        for (String key : keyid)
        {
            row = spreadsheet.createRow(rowid++);
            Object [] objectArr = rows.get(key);
            int cellid = 0;
            for (Object obj : objectArr)
            {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        byte[] workbookBytes;

        try(ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            workbook.write(out);

            workbookBytes = out.toByteArray();

            workbook.close();
        }

        return workbookBytes;

    }

}
