package ExtentReports;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentsDemo 
{

	
//	public static ExtentReports extobj;
//	public static ExtentSparkReporter extspk;
	

	public static ExtentReports config() 
	{
		//Onject creation for ExtentSparkReporter
		File floc=new File(System.getProperty("user.dir")+"//Reports//index.html");
		ExtentSparkReporter extspk = new ExtentSparkReporter(floc);
		extspk.config().setReportName("Web Automation Report");	
		extspk.config().setDocumentTitle("Tests Result");
		
		
		//object creation for ExtentReports
		ExtentReports extobj=new ExtentReports();
		extobj.attachReporter(extspk);
		extobj.setSystemInfo("QA", "Anjali Rathi");
		
		return extobj;
		
		
	}
	
	
//	@Test
//	public void demoMethod() 
//	{
//		extobj.createTest("First Test Report");
//		System.setProperty("webdriver.chrome.driver", "C:/Users/prata/OneDrive/Documents/Chrome.exe file/chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://rahulshettyacademy.com/");
//		driver.manage().window().maximize();
//		System.out.println(driver.getTitle());
//		rep.flush();
		
	}
	
	
