package frameworkpack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilpack.UtilClass;

public class ProductCatalogue extends UtilClass {
	WebDriver driver;
	By addedcard = By.cssSelector(".btn.w-10.rounded");

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> List1;

	public List<WebElement> getProduct() throws InterruptedException {
		waitmethod();
		return List1;
	}

	public void getProductName(String ProductName) throws InterruptedException {
		for (WebElement list : List1) {

			if (list.getText().contains(ProductName)) {

//				System.out.println(list.getText());
				WebElement addcart = list.findElement(addedcard);
				addcart.click();
				waitmethod();
			}
		}
	}

}
