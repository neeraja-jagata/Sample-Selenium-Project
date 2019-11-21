package udemyExamples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesEg {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		
		WebElement frame=driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame);
		//driver.findElement(By.xpath("/html/body/button")).click();
		//((JavascriptExecutor) driver).executeScript("myFunction()");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("myFunction()");
		js.executeAsyncScript("arguments[0].style.border='3px solid red'", driver.findElement(By.id("mySubmit")));
		
		/*driver.switchTo().defaultContent();
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (WebElement ele : frames) {
			System.out.println(ele.getAttribute("id")+"		"+ele.getAttribute("name"));
		}*/
		

	}

}
