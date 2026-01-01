package com.qa.utilities;

import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

//        String path="..\\testData\\testData.xlsx";
//        String path=System.getProperty("user.dir") +"/testData/data.xlsx";
        ExcelUtility excelUtility=new ExcelUtility();

        int totalrows=excelUtility.getRowCount("Sheet1");
        int totalcells=excelUtility.getCellCount("Sheet1",1);

        String logindata[][]=new String[totalrows][totalcells];

        for (int i=1;i<totalrows;i++){
            for (int j=0;j<totalcells;j++){
                logindata[i-1][j]=excelUtility.getCellData("Sheet1",i,j);
            }
        }
        return logindata;
    }
}
