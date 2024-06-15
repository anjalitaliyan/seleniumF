package frameworkpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilpack.UtilClass;

public class LandingPage extends UtilClass {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement Email;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement Errormessage;
	
	public void gotoURL() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

	public ProductCatalogue LoginApplication(String Emailname, String pass) {
		Email.sendKeys(Emailname);
		password.sendKeys(pass);
		submit.click();
		ProductCatalogue pc = new ProductCatalogue(driver);
		return pc;

	}
	
	public String getErrorMessage() throws InterruptedException
	{
		Thread.sleep(1000);
		String error=Errormessage.getText();
		return error;
		
		
	}
}
