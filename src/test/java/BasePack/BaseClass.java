package BasePack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import frameworkpack.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public LandingPage lp;

	public WebDriver intializeBrowser() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resourcepack\\resource.properties");
		prop.load(fis);
//		String browserName=prop.getProperty("browser");

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));  //full screen

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		else if (browserName.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();
		return driver;
	}

	// How to take sceenshot
	public static String takescreenshot(String testname, WebDriver driver) throws IOException {

		TakesScreenshot screen = (TakesScreenshot) driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "//screenshotreports//" + testname + ".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir") + "//screenshotreports//" + testname + ".png";
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage LaunchApplication() throws IOException {

		driver = intializeBrowser();
		lp = new LandingPage(driver);
		lp.gotoURL();
		return lp;

	}

	@AfterMethod(alwaysRun = true)
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}

}
