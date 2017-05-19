package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToursPageObject {
	private WebDriver driver;
	
	@FindBy(linkText = "Tours")
	private WebElement tourButton;
	
	@FindBy(xpath = "//button[contains(text(),'Book Now')]")
	public WebElement BookButton;
	
	@FindBy(partialLinkText = "Spectaculars")
	private WebElement tourLink;
	
	@FindBy(xpath = "//button[contains(text(),'CONFIRM THIS BOOKING')]")
	private WebElement confirmBooking;
	
	@FindBy(xpath = "//button[contains(text(),'Pay on Arrival')]")
	private WebElement payment;

	@FindBy(css = "b.btn.btn-danger")
	private WebElement unpaid;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	public WebElement confirmOk;
	
	@FindBy(css= "div.modal-body")
	private WebElement amount;
		
	public ToursPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToTours(){
		this.tourButton.click();
	}
	
	public void selectTour(){
		this.tourLink.click();
	}
	
	public void BookTour(){
		this.BookButton.click();
	}
	
	public void confirmation() {
		this.confirmBooking.click();
	}
	
	public String getUnpaid(){
		return unpaid.getText();
	}
	
	public void gotoPayment(){
		this.payment.click();
	}
	
	public String getPrice(){
		return amount.getText();
	}
	
	public void getHomePage(String url){
		 driver.get(url);
	}
	
}
