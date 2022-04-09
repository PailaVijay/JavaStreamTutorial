import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class Table_Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver_win32 (1)//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		//capture all the webelement into list
	     List<WebElement> columnlist= driver.findElements(By.xpath("//tr/td[1]"));
		//capture all webelement text into original list
		List<String> originallist=columnlist.stream().map(s->s.getText()).collect(Collectors.toList());
		//sort on the original list
		List<String>sortedlist=originallist.stream().sorted().collect(Collectors.toList());
		//compare original list vs sorted list
		Assert.assertTrue(originallist.equals(sortedlist));
		// scan the column get the text apple and get the price 
		List<String> price;
		do
		{
		 List<WebElement>columnlist1= driver.findElements(By.xpath("//tr/td[1]"));
		price=columnlist1.stream().filter(s->s.getText().contains("Wheat")).map(s->getVegiPrice(s))
				.collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		
		}while(price.size()<1);
		
	}

	private static String getVegiPrice(WebElement s) {
		// TODO Auto-generated method stub
		String value =s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return value;
		
	}

}
