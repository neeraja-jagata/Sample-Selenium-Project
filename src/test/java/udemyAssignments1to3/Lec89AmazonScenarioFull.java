package udemyAssignments1to3;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lec89AmazonScenarioFull {

	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 10);

		Actions action=new Actions(driver);
		try {
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Headphones");
		driver.findElement(By.id("nav-search-submit-text")).submit();
		System.out.println("typed headphones and clicked submit button");
		List<WebElement> bestSellerElements=driver.findElements(By.xpath("//*[.='Best Seller']"));// adding all bestseller ele to list
		//WebElement target;
		
		for (int i=1;i<=bestSellerElements.size();i++) {
			//target=webElement.findElement(By.xpath("//*[.='Best Seller']/following::div[@class='sg-row']//*[@class='sg-col-inner']"));
			action.keyDown(Keys.LEFT_CONTROL)
				.click(driver.findElement(By.xpath("(//*[.='Best Seller'])["+i+"]/following::div[@class='sg-row']//*[@class='sg-col-inner']")))
				.keyUp(Keys.LEFT_CONTROL).build().perform();
		}
		System.out.println("clicked/openend all on BestSeller items to new window");
		
		Set<String> bsItemsWindows=driver.getWindowHandles();
		System.out.println(bsItemsWindows.size());
		Iterator<String> itr=bsItemsWindows.iterator();
		String mainWindow=itr.next();
		while(itr.hasNext()) {
			driver.switchTo().window(itr.next());
			driver.findElement(By.id("add-to-cart-button")).click();
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='siNoCoverage-announce']"))).click();
				System.out.println("siNoCoverage ele present and clicked");
			} catch (TimeoutException e) {	System.out.println("siNoCoverage ele not present ");	}
			//driver.findElement(By.xpath("//*[@id='siNoCoverage-announce']")).click();
			driver.close();
			System.out.println("Added  to cart buton and closed window");
		}
		driver.switchTo().window(mainWindow);
		driver.navigate().refresh();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		//captureScreenshot();
		WebElement ele= driver.findElement(By.id("nav-logo"));
		captureElementScreeshot(ele);
		
		}catch(WebDriverException e) {
			System.out.println(e);
		}

	}

	public static void captureScreenshot() throws IOException{
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		File screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//screenshot//"+fileName));
		
	}
	
	public static void captureElementScreeshot(WebElement ele) throws IOException {
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		File screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullScreenshot= ImageIO.read(screenshot);
		
		Point eleposition=ele.getLocation();
		int height=ele.getSize().getHeight();
		int width= ele.getSize().getWidth();
		System.out.println(eleposition.getX()+"	"+eleposition.getY()+"	"+height+"	"+width);
		
		BufferedImage eleScreenshot = fullScreenshot.getSubimage(eleposition.getX(), eleposition.getY(), width, height);
		ImageIO.write(eleScreenshot, "jpg", screenshot);

		File screenshotLocation = new File(".\\screenshot\\"+fileName);
		FileUtils.copyFile(screenshot, screenshotLocation);

				
	}
}

////*[.='Best Seller']/following::div[@class='sg-row']