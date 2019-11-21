package udemyAssignments1to3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountOfAllLinks {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
		driver.get("http://www.wikipedia.org/");
		/*----------Print All Elements in Dropdown----------*/
		System.out.println(driver.findElement(By.id("searchLanguage")).isDisplayed());
		Select languageDropDown=new Select(driver.findElement(By.id("searchLanguage")));
		languageDropDown.selectByIndex(1);
		List<WebElement> languageOptions=languageDropDown.getOptions();
		System.out.println("Count of options: "+languageOptions.size() );
		for (WebElement ele : languageOptions) {
			System.out.println(ele.getAttribute("value")+"	"+ele.getAttribute("lang")+"	"+ele.getText());
		}
		/*----------Print Count of All Links In WebPage----------*/
		List<WebElement> Totallinks=driver.findElements(By.tagName("a"));
		System.out.println("Count of Total Links: "+ Totallinks.size());
		/*----------Print All Links In a Block----------*/
		WebElement block=driver.findElement(By.xpath("//*[@class='other-projects']"));
		List<WebElement> links=block.findElements(By.tagName("a"));
		System.out.println("Count of Links in other-projects block: "+ links.size());
		for (WebElement link : links) {
			System.out.println(link.getText()+"	"+link.getAttribute("href"));
		}		
				
		} catch(WebDriverException e) {
			System.out.println(e);
		}
		
	}

}
