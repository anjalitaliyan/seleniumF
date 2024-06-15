package utilpack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkpack.CartPage;
import frameworkpack.OrderPage;

public class UtilClass {
	WebDriver driver;

	public UtilClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartele;

	public void waitmethod() throws InterruptedException {
		Thread.sleep(2000);
	}

	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement orderclick;
	
	public CartPage gotoCart() {
		cartele.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
	
	public OrderPage OrderButton() 
	{
		orderclick.click();
		OrderPage op=new OrderPage(driver);
		return op;
		
	}

	
}
