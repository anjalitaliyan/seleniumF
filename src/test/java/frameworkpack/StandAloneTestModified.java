package frameworkpack;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePack.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import testData.ReadJsonData;

public class StandAloneTestModified extends BaseClass {
	String s = "IPHONE 13 PRO";
	String countrynameis = "india";

	@Test(dataProvider = "hashMapData")
	public void placedOrder(HashMap<String, String> obj) throws IOException, InterruptedException {
		ProductCatalogue obj2 = lp.LoginApplication(obj.get("username"), obj.get("password")); // Handled Landing Page

		obj2.getProduct(); // Handled Product Page
		obj2.getProductName(s);

		CartPage obj3 = obj2.gotoCart(); // Handled CartPage
		obj3.getCartName(s);

		CheckoutPage obj4 = obj3.checkOut(); // Handled CheckoutPage
		obj4.getCountry(countrynameis);

		ConfirmPage obj5 = obj4.submitMethod(); // Handled ConfirmPage
		String confirm = obj5.getconfirmtext();
		System.out.println(confirm);
		Assert.assertTrue(confirm.equalsIgnoreCase("THANKYOU for the order."));
	}

	@Test(dependsOnMethods = { "placedOrder" })
	public void OrderHistory() {
		ProductCatalogue obj2 = lp.LoginApplication("anjalitaliyan@gmail.com", "Pratap@999");

		OrderPage obj = obj2.OrderButton();
		obj.checkingOrder(s);

	}

	@DataProvider
	public Object[][] hashMapData() throws IOException {

		ReadJsonData jsonobj = new ReadJsonData();
		List<HashMap<String, String>> mapdata = jsonobj
				.getJsonDatatoMap(System.getProperty("user.dir") + "\\src\\test\\java\\testData\\Jsondata.json");
		return new Object[][] { { mapdata.get(0) }, { mapdata.get(1) } };

//	HashMap<String, String> hobj=new HashMap<String, String>();
//	hobj.put("username", "anjalitaliyan@gmail.com");
//	hobj.put("password","Pratap@999");
//	
//	HashMap<String, String > hobj1=new HashMap<String, String>();
//	hobj1.put("username", "anjalitaliyan999@gmail.com");
//	hobj1.put("password", "Anjali@999");
//	
//	return new Object[][] {{hobj}, {hobj1}};

//	@DataProvider
//	public Object[][] getData() {
//		//firstSet -username and password
//		Object[][] dataobj = new Object[2][2];
//		dataobj[0][0]="anjalitaliyan@gmail.com";
//		dataobj[0][1]="Pratap@999";
//		
//		dataobj[1][0]="anjalitaliyan999@gmail.com";
//		dataobj[1][1]="Anjali@999";
//		return dataobj;

	}

}
