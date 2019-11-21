package udemyAssignments1to3;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lec105Ass4WindowResizeing {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println(driver.manage().window().getSize());
		int maxHeight=driver.manage().window().getSize().getHeight();
		int maxWidth=driver.manage().window().getSize().getWidth();
		//Dimension d= new Dimension(150,200);
		//driver.manage().window().setSize(d);
		
		Thread.sleep(2000);
		for (int width = 150, height = 200; width<= maxWidth && height<= maxHeight; width++, height++) {
			driver.manage().window().setSize(new Dimension(width, height));
			}
		
		
		
		


	}

}
