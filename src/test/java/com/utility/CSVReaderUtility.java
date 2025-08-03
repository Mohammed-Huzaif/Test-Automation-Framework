package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {
    public static Iterator<User> readCSVFile(String filename)  {

        File csvFile = new File(System.getProperty("user.dir")+ "//testData//" + filename);
        FileReader fileReader = null;
        CSVReader csvReader = null;
        String line[];
        List<User> userList = null;
        User userData;

        try {
            fileReader = new FileReader(csvFile);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext(); // Reading the columns name (immediate line)
//            csvReader.readNext(); // Read row 2
//            csvReader.readNext(); // Read row 3
//            data = csvReader.readNext();  //Row 4 [No row, or we have reached at the end of the CSV file
//             // readNext retuns null]

           userList = new ArrayList<>();
            while ((line = csvReader.readNext())!=null){
                userData = new User(line[0],line[1] );
                userList.add(userData);
            }

        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }

        return userList.iterator();

    }
}
