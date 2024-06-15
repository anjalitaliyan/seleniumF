package frameworkpack;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderPage 
{

	WebDriver driver;
	public OrderPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tbody tr td:nth-child(3)")
	List<WebElement> OrderList;
	
	public void checkingOrder(String ordername)
	{
		for(WebElement Eachorder:OrderList) 
		{
			if(Eachorder.getText().equalsIgnoreCase(ordername)) 
			{
				System.out.println(Eachorder.getText());
				Assert.assertEquals(ordername,Eachorder.getText());
			}
		}
	}
	
}
