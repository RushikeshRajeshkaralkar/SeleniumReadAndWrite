import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.Column;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class flipcart {
	@Test
	public void filpcart() {
		Xls_Reader reader = new Xls_Reader("A:\\JavaPrograms\\SeleniumReadAndWrite\\src\\test\\java\\Book1.xlsx");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rushikesh\\Desktop\\ChromeDriver79\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");

		WebElement loginalert = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		if (loginalert.isDisplayed()) {
			loginalert.click();
		}

		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("input")));
		links.addAll(driver.findElements(By.tagName("button")));

		if (!reader.isSheetExist("Flipkart")) {

			reader.addSheet("Flipkart");
			reader.addColumn("Flipkart", "FilpkartData");

		}

		for (int i = 0; i < links.size(); i++) {
			String list = links.get(i).getText();
			System.out.println(list);
			reader.setCellData("Flipkart", "FilpkartData", i, list);

		}

		driver.close();
	}
}
