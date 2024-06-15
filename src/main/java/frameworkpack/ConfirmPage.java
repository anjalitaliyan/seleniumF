package frameworkpack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilpack.UtilClass;
public class ConfirmPage 
{
	WebDriver driver;
	public ConfirmPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirm;
	
	//String confirm = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	public String getconfirmtext() 
	{
		return confirm.getText();
		
	}

}
