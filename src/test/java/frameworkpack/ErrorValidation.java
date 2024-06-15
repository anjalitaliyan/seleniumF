package frameworkpack;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePack.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseClass
{

	@Test(groups= {"errortest"})
	public void placedOrder() throws IOException, InterruptedException
	{

		String s = "IPHONE 13 PRO";
		String countrynameis = "india";
		ProductCatalogue obj2 = lp.LoginApplication("anjalitaliyan999@gmail.com", "Anjali@900");  //Handled Landing Page
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMessage());
		
		
	}

}
