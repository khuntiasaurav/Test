package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;
import pageObjects.MainPageObjects;

import static org.assertj.core.api.Assertions.assertThat;

import service.Browser;

public class LoginTest extends Browser {
	private MainPageObjects mpo;
	private LoginPageObjects lpo;
	private String MAINPAGE = "http://phptravels.com/demo/";
	private String LOGINURL = "http://www.phptravels.net/admin";
	private String EMAIL = "admin@phptravels.com";
	private String PASSWORD = "demoadmin";
	
	@BeforeClass
	public void setup(){
		mpo = new MainPageObjects(driver);
		lpo = new LoginPageObjects(driver, ngDriver);
	}
	
	@Test
	public void checkOpenWindows()  {
		mpo.getMainPage(MAINPAGE);
		checkPageTitle(mpo.TITLE);
		mpo.goToLoginPage();
		assertThat(mpo.getOpenWindows()).isEqualTo(2);
	}
	
	@Test
	public void loginSucess(){
        lpo.getLoginPage(LOGINURL);
		checkPageTitle(lpo.TITLE);

		checkPanelHeader("Login Panel");
		lpo.loginIn(EMAIL, PASSWORD);
		
		assertThat(lpo.getSuccess()).isEqualTo("Redirecting Please Wait...");
	}
	
	@Test
	public void invalidLogin(){
		lpo.getLoginPage(LOGINURL);
		checkPanelHeader("Login Panel");
		lpo.loginIn(EMAIL, "INVALID");
		
		assertThat(lpo.getErrorText()).isEqualTo("Invalid Login Credentials");	
	}
	
	/** Attempt at task 1. Was not able to redirect to the super Admin Dashboard
	 * Please uncomment the test and run */
//	@Test
//	public void adminDashBoard() {
//		lpo.getLoginPage(LOGINURL);
//		checkPageTitle(lpo.TITLE);
//
//		checkPanelHeader("Login Panel");
//		lpo.loginIn(EMAIL, PASSWORD);
//		
//		checkContainsText("div.user.text-center", "Super Admin", 10);
//	}
	
	@AfterClass
	public void tearDown(){
		mpo = null;
		lpo = null;
	}

}
