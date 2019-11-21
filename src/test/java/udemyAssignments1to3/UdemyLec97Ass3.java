package udemyAssignments1to3;

import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UdemyLec97Ass3 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		String str=driver.findElement(By.id("mathq2")).getText();
		System.out.println(str);
		String[] array=str.split(" ");
		
		//System.out.println(array[1]);
		String s=null;
		//System.out.println(Integer.parseInt(array[0])+array[1]+Integer.parseInt(array[2]));
		if(array[1].equals("+")) {
			int i=(Integer.parseInt(array[0])-Integer.parseInt(array[2]));
			s=String.valueOf(i);
		}else if(array[1].equals("-")){
			int i=Integer.parseInt(array[0])-Integer.parseInt(array[2]);
			s=String.valueOf(i);
		}else if(array[1].equals("*")){
			int i=Integer.parseInt(array[0])*Integer.parseInt(array[2]);
			s=String.valueOf(i);
		}
		
		System.out.println(s);
	}

}
