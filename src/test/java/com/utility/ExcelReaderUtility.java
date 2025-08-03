package com.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {
    public static Iterator<User> readExcelFile(String filename) {
        File xlsxFile = new File(System.getProperty("user.dir") + "//testData//" + filename);
        XSSFWorkbook xssfWorkbook = null;
        XSSFSheet xssfSheet;
        Row row;
        Cell emailaddressCell;
        Cell passwordCell;
        User user;
        List<User> userList = null;
        Iterator<Row> rowIterator;
        try {
            //XLSX file
            xssfWorkbook = new XSSFWorkbook(xlsxFile);
            xssfSheet = xssfWorkbook.getSheet("LoginTestData");
            userList = new ArrayList<User>();
            rowIterator = xssfSheet.iterator();
            rowIterator.next(); //Skipping column name
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                emailaddressCell = row.getCell(0);
                passwordCell = row.getCell(1);
                user = new User(emailaddressCell.toString(), passwordCell.toString());
                userList.add(user);
                xssfWorkbook.close();
            }
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        return userList.iterator();

    }
}
