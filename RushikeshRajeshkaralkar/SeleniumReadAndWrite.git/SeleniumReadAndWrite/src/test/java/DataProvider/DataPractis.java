package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataPractis {

	
	public static ArrayList<Object[]> LoginData() {
		
		ArrayList<Object[]> mydata=new ArrayList<Object[]>();

		File src = new File("C:\\Users\\Rushikesh\\Desktop\\ExcelWoorkBook\\Dataof.xlsx");

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook work = null;
		try {
			work = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = work.getSheetAt(0);
		int colum = sheet.getLastRowNum();

		System.out.println(colum);
		for (int i = 1; i < colum+1; i++) {
			String userdata = sheet.getRow(i).getCell(0).getStringCellValue();
		
			String passdata=sheet.getRow(i).getCell(1).getStringCellValue();
			Object[] obj= {userdata,passdata};
			mydata.add(obj);
		}
		return mydata;

	}

}
