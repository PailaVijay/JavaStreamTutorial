import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Amazon_Filter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver_win32 (1)//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("sumsung");
		List<WebElement>mobileList=driver.findElements(By.xpath("//div[@class='s-suggestion']"));
		List<WebElement>getmobile= mobileList.stream().filter(s->s.getText().contains("sumsungnote20 ultra"))
				.collect(Collectors.toList());
		
		Assert.assertEquals(mobileList.size(), getmobile.size());
		
		
	}

}
