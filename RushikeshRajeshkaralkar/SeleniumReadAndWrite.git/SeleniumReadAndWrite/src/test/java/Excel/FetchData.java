package Excel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class FetchData {

	@Test
	public void fetchTableData() {
		Xls_Reader reader = new Xls_Reader("A:\\JavaPrograms\\SeleniumReadAndWrite\\src\\test\\java\\Data.xlsx");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rushikesh\\Desktop\\ChromeDriver79\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@name='Submit']")).submit();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//b[text()='Admin']")))
				.moveToElement(driver.findElement(By.xpath("//a[text()='User Management']"))).build().perform();
		actions.click(driver.findElement(By.xpath("//a[text()='Users']"))).build().perform();
		List<WebElement> listOfData = driver.findElements(By.xpath("//div[@id='tableWrapper']//tr//td"));
		System.out.println(listOfData.size());
		for (int i = 3; i < listOfData.size(); i++) {
			String listofelement = listOfData.get(i).getText();

			boolean data=reader.setCellData("Sheet2", "Username", i, listofelement);
			boolean data2=reader.setCellData("Sheet2", "Role", i, listofelement);
			boolean data3=reader.setCellData("Sheet2", "Employee", i, listofelement);
			boolean data4=reader.setCellData("Sheet2", "Status", i, listofelement);
			
			System.out.println(data);
			
			System.out.println(listofelement);

		}
		
		
		driver.quit();

	}

}
