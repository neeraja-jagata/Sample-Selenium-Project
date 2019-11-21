package udemyExamples;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AshotScreenshot {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.way2automation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		WebElement ele = driver.findElement(By.xpath("/html/body/div[4]/div/header/div[2]/div/div[1]"));

		//Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.viewportNonRetina(1000, 242, 0)).takeScreenshot(driver);
		//Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,ele);
		
		//ImageIO.write(screenshot.getImage(), "jpg", new File(".//screenshot//ashotsc1.jpg"));
		ImageIO.write(screenshot.getImage(), "jpg", new File(".//screenshot//"+fileName));


	}

}
