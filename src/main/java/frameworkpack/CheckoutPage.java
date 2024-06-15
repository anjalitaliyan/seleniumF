package frameworkpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilpack.UtilClass;

public class CheckoutPage extends UtilClass {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectcountry;

	@FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
	WebElement submitbuton;

	public void getCountry(String yourcountry) throws InterruptedException {
		country.sendKeys(yourcountry);
		waitmethod();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group")));
		selectcountry.click();

	}

	public ConfirmPage submitMethod() {
		submitbuton.click();
		ConfirmPage cpage=new ConfirmPage(driver);
		return cpage;

	}

}
