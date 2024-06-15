package frameworkpack;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException 
	{
		
		String s="IPHONE 13 PRO";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("anjalitaliyan999@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Anjali@999");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		List<WebElement> List=driver.findElements(By.cssSelector(".mb-3"));
		
		
			
			for(WebElement list:List) 
			{
				
				if(list.getText().contains("IPHONE")) 
				{
					System.out.println(list.getText());
					list.findElement(By.cssSelector(".btn.w-10.rounded")).click();
				}
		}
			
			Thread.sleep(4000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
//			wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//div[@id='toast-container']//div[@role='alert']"), "Product Added To Cart"));
			driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
			
			List<WebElement> cartlist = driver.findElements(By.cssSelector(".cartSection h3"));
			for(WebElement cart:cartlist) 
			{
				if(cart.getText().equalsIgnoreCase(s)) 
				{
					driver.findElement(By.xpath("//li[@class='totalRow']//button")).click();
				}
				
			}
			driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group")));	
			driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
			driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();		
			String confirm=driver.findElement(By.cssSelector(".hero-primary")).getText();
			Assert.assertTrue(confirm.equalsIgnoreCase("THANKYOU for the order."));
			System.out.println(confirm);
		
			
			
			Thread.sleep(3000);
			driver.quit();
			
	}

}
