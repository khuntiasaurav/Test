package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class LoginPageObjects {
	private WebDriver driver;
	private NgWebDriver ngDriver;
	public String TITLE = "Administator Login";
	
	@FindBy(name = "email")
	public WebElement emailField;
	
	@FindBy(name = "password")
	public WebElement passwordField;
	
	@FindBy(css = "span.ladda-label")
	public WebElement loginButton;
	
	@FindBy(css = "h2.form-heading.text-center")
	public WebElement loginText;
	
	@FindBy(css = "div.alert.alert-danger")
	public WebElement invalidLogin;
	
	@FindBy(css = "div.alert.alert-success")
	public WebElement success;
	
	@FindBy(css = "div.user.text-center")
	public WebElement adminUser;
	
	
	public LoginPageObjects(WebDriver driver, NgWebDriver ngDriver) {
		this.driver = driver;
		this.ngDriver = ngDriver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPageObjects loginIn(String emails, String passwords){
		this.emailField.sendKeys(emails);
		this.passwordField.sendKeys(passwords);
		this.loginButton.click();
		ngDriver.waitForAngularRequestsToFinish();
		return new LoginPageObjects(driver, ngDriver);
	}
	
	public void getLoginPage(String url){
		driver.get(url);
	}
	
	public String getErrorText(){
		return invalidLogin.getText();
	}
	
	public String getSuccess(){
		return success.getText();
	}
	
}
