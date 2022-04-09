import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filter_Functionality {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver_win32 (1)//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("man");
		List<WebElement>vegetableList=driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement>filteredvegetable=vegetableList.stream().filter(v->v.getText().contains("Mango")).
				collect(Collectors.toList());
		Assert.assertEquals(vegetableList.size(), filteredvegetable.size());
	}

}
