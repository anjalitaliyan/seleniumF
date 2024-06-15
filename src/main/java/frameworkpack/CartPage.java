package frameworkpack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilpack.UtilClass;

public class CartPage extends UtilClass {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> CartList1;

	@FindBy(xpath = "//li[@class='totalRow']//button")
	WebElement button;

	public List<WebElement> getProduct() throws InterruptedException {
		waitmethod();
		return CartList1;
	}

	public void getCartName(String cartname) throws InterruptedException {
		for (WebElement list : CartList1) {

			if (list.getText().equalsIgnoreCase(cartname)) {
				Assert.assertTrue(true, list.getText());

			}

		}
	}

	public CheckoutPage checkOut() {
		button.click();
		CheckoutPage cop=new CheckoutPage(driver);
		return cop;

	}

}
