package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcountsPageObjects {
	private WebDriver driver;
	
	@FindBy(name = "username")
	public WebElement emailField;
	
	@FindBy(name = "password")
	public WebElement passwordField;
	
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	public WebElement loginButton;
	
	public AcountsPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AcountsPageObjects customerLoginIn(String usernames, String passwords){
		this.emailField.sendKeys(usernames);
		this.passwordField.sendKeys(passwords);
		this.loginButton.click();
		return new AcountsPageObjects(driver);
	}

}
