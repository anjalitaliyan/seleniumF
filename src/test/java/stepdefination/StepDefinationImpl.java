package stepdefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BasePack.BaseClass;
import frameworkpack.CartPage;
import frameworkpack.CheckoutPage;
import frameworkpack.ConfirmPage;
import frameworkpack.LandingPage;
import frameworkpack.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImpl extends BaseClass
{

 public LandingPage lp;
 public ProductCatalogue obj2;
 public ConfirmPage obj5;
 @Given("Using these steps for landing page")
 public void landing_page() throws IOException 
 {
	lp= LaunchApplication();
 }
 
 @Given("^Logged in with (.+) and (.+)$")
 public void Login(String username, String password) {
	 obj2 = lp.LoginApplication(username, password);
	 
 }
 @When("^Added the product (.+) to the cart$")
 public void Added_to_Cart(String productName) throws InterruptedException {
	
	List<WebElement> List=obj2.getProduct(); 
	obj2.getProductName(productName);
	 
 }

 @And("^checkout the (.+) and submit the order$")
 public void checkout_submit_order(String productName) throws InterruptedException {
	 CartPage obj3 = obj2.gotoCart(); // Handled CartPage          
		obj3.getCartName(productName);
		CheckoutPage obj4 = obj3.checkOut(); // Handled CheckoutPage
		obj4.getCountry("india");

		obj5 = obj4.submitMethod(); 
	 
 }

 
 @Then("{string} message displayed on the confirmation page.")
 public void message_confirmation_page(String string) throws InterruptedException {
	 
	 String confirm = obj5.getconfirmtext();
		System.out.println(confirm);
		Assert.assertTrue(confirm.equalsIgnoreCase(string));
		
		Thread.sleep(2000);
		driver.quit();
 }
 
 @Then("{string} message is displayed.")
 public void Error_Message(String string) throws InterruptedException {
	 Assert.assertEquals(string, lp.getErrorMessage());
	 Thread.sleep(2000);
		driver.quit();
	 
 }
 
 
 
 
 
	
}
