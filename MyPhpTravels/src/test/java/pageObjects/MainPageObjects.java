package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class MainPageObjects {
	private WebDriver driver;
	public String TITLE = "PHPTRAVELS | Demo";
	
	@FindBy(linkText = "http://www.phptravels.net/admin")
	public WebElement loginUrl;

	public MainPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToLoginPage(){
		loginUrl.click();
	}
	
	public int getOpenWindows(){
		return driver.getWindowHandles().size();
	}
	
	public void getMainPage(String url){
		driver.get(url);
	}

}
