package udemyAssignments1to3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UdemyLec96Ass2 {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Neeraja\\Documents\\java\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		driver.findElement(By.name("name")).sendKeys("way2automation");
		driver.findElement(By.xpath("//*[@class='ajaxsubmit']//*[@class='button']")).click();
		System.out.println("clicked on submit button");
		
	}

}
