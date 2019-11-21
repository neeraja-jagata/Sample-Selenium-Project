package udemyExamples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebTable {

	public static WebDriver driver;

	public static void main(String[] args) {
// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));

		System.out.println("Total number of rows are " + rows.size());

		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));

		System.out.println("Total number of cols are " + cols.size());

		for (int row = 1; row <= rows.size(); row++) {
			for (int col = 1; col <= cols.size(); col++) {
				System.out.print(driver
						.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + row + "]/td[" + col + "]"))
						.getText() + "		");
			}
			System.out.println();
		}

	}

}