package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.TestBase;

public class vGUI_Login extends TestBase{
	
	private static vGUI_Login login;
	private vGUI_Login()
	{
		PageFactory.initElements(driver, this);
	}
	
	public static vGUI_Login getvGUI_Login()
	{
		if(login==null)
		{
			login=new vGUI_Login();
		}
		
		return login;
	}
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	public void loginToApp()
	{
		username.sendKeys("admin");
		password.sendKeys("admin123");
		submit.click();
	}
}
