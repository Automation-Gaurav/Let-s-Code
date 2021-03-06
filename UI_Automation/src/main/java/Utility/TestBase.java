package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;

	public static String readProperty(String key) {
		prop = new Properties();
		try {
			fis = new FileInputStream(
					"C:\\Gaurav\\Workspace_UI_Automation\\UI_Automation\\src\\main\\java\\TestData\\testData.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = prop.getProperty(key);
		System.out.println("value is "+value);
		return value;
	}

	@BeforeTest
	public static void inilizeBrowser() {
		if (readProperty("Browser").equalsIgnoreCase("firefox")) {
			System.out.println("in firefox browser");
			System.setProperty("webdriver.gecko.driver",
					"C:\\Gaurav\\Workspace_UI_Automation\\UI_Automation\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (readProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "");
			driver = new ChromeDriver();
		}

		else if (readProperty("Browser").equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.internetexplorer.driver", "");
			driver = new InternetExplorerDriver();
		}
		
		driver.get(readProperty("Url"));
	}

}
