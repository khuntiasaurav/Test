package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class HomePageObjects {
	private WebDriver driver;
	
	@FindBy(linkText = "My Account")
	public WebElement accountButton;
	
	@FindBy(linkText = "Login")
	public WebElement loginButton;

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToLogin() {
		accountButton.click();
		loginButton.click();
	}

}
