package Excel;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class W3CFetchdata {

	@Test
	public void FetchData()
	{
		Xls_Reader reader = new Xls_Reader("A:\\JavaPrograms\\SeleniumReadAndWrite\\src\\test\\java\\Data.xlsx");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rushikesh\\Desktop\\ChromeDriver79\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		List<WebElement> list=driver.findElements(By.xpath("//table[@id='customers']//tbody//tr"));
		String beforXpath="//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath="]/th[1]";
		if(!reader.isSheetExist("DataSet1"))
		{
			reader.addSheet("DataSet1");
			reader.addColumn("DataSet1", "Company");
			reader.addColumn("DataSet1", "Employee");
			
		}
		reader.addColumn("DataSet1", "Mobile");
		
		
		System.out.println(list.size());
		for(int i=2;i<list.size();i++)
		{                                                 
			String CompanyName=driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+i+"]/td[1]")).getText();
			reader.setCellData("DataSet1", "Company", i, CompanyName);
			System.out.println(CompanyName);
			
			String EmployeeName=driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+i+"]/td[2]")).getText();
			reader.setCellData("DataSet1", "Employee", i, EmployeeName);
			System.out.println(EmployeeName);
			

			String Mobile=driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+i+"]/td[3]")).getText();
			reader.setCellData("DataSet1", "Mobile", i, Mobile);
			System.out.println(Mobile);
			
			
		}
		driver.quit();
	}
}
