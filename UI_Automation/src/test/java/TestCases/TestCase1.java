package TestCases;

import org.testng.annotations.Test;

import PageObjects.vGUI_Login;
import Utility.TestBase;

public class TestCase1 extends TestBase {

	@Test
	public static void validate_Login() {

		vGUI_Login login = vGUI_Login.getvGUI_Login();
		login.loginToApp();
	}

}
