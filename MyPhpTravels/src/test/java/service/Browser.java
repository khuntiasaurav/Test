package service;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class Browser {
	protected WebDriver driver;
	protected NgWebDriver ngDriver;
	
	@BeforeClass
	public void startSelenium() {
		driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_45, true);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		// waitForAngular is an async JS call
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		
		ngDriver = new NgWebDriver((JavascriptExecutor)driver);
	}
	
	@AfterClass
	public void TearDown() {
		if (driver != null)
			driver.quit();
		driver = null;
	}
	
	protected void checkPageTitle(String title) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs(title));
	}
	
	protected void checkCurrentUrl(String url){
		new WebDriverWait(driver,5).until(ExpectedConditions.urlToBe(url));
	}
	
	protected void checkPanelHeader(String header){
		new WebDriverWait(driver, 5).until(ExpectedConditions.textToBe(
				By.cssSelector("h2.form-heading.text-center"), header));
	}
	
	protected void checkHeader(){
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div.panel-heading")));
	}
	
	protected void checkContainsText(String cssSelector, String text, int wait) {
		new WebDriverWait(driver, wait).until(
			ExpectedConditions.textToBePresentInElementLocated(
				By.cssSelector(cssSelector),
				text
			)
		);
	}
	
	protected void checkNoButton(){
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.invisibilityOfElementLocated(
						By.cssSelector("span.ladda-label")));
	}
	
}

