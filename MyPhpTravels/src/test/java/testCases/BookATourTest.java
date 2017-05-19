package testCases;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AcountsPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.ToursPageObject;
import service.Browser;
import static org.assertj.core.api.Assertions.assertThat;

public class BookATourTest extends Browser {
	private HomePageObjects hpo;
	private AcountsPageObjects apo;
	private ToursPageObject tpo;
	private String HOMEPAGE = "http://www.phptravels.net/";
	private String USERNAME = "user@phptravels.com";
	private String PASSWORD = "demouser";
	

	@BeforeClass
	public void setup(){
		hpo = new HomePageObjects(driver);
		apo = new AcountsPageObjects(driver);
		tpo = new ToursPageObject(driver);
		
	}
	
	/** Task 3: As a new customer, book a tour*/
	@Test
	public void BookTour() {
		tpo.getHomePage(HOMEPAGE);
		checkPageTitle("PHPTRAVELS | Travel Technology Partner");
		hpo.goToLogin();
		checkContainsText("div.panel-body", "Email", 5);

		apo.customerLoginIn(USERNAME, PASSWORD);
		checkContainsText("h3.RTL", "John Smith", 10);

		tpo.goToTours();
		checkContainsText("div.searchbox", "Quick Search", 5);

		tpo.selectTour();
		checkContainsText("div.panel-heading.panel-green", "Details", 5);
		tpo.BookTour();
		checkContainsText("div.bookingside", "Booking Summary", 5);
		tpo.confirmation();

		assertThat(tpo.getUnpaid()).isEqualTo("Unpaid");
		assertThat(tpo.getPrice()).contains("Total Amount USD $165")
		                          .contains("Deposit Now USD $16.50");
	}
	
	@AfterClass
	public void tearDown(){
		hpo = null;
		apo = null;
		tpo = null;
	}
}
