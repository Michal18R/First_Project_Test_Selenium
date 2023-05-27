package pl.seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelSearchPage {
    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchHotelSpan;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchHotelInput;

    @FindBy(name = "checkin")
    private WebElement checkInImput;

    @FindBy(name = "checkout")
    private WebElement checkOutInput;

    @FindBy(id = "travellersInput")
    private WebElement travelersInput;

    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy(id = "childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;


    @FindBy(xpath = "//li[@id='li_myaccount']")
    private List<WebElement> myAccountLink;

    @FindBy(xpath = "//a[text()='  Sign Up']")
    private List<WebElement> signUpLink;

    private WebDriver driver;

    private static final Logger Logger = LogManager.getLogger();

    public HotelSearchPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HotelSearchPage setCity(String cityName) {
        Logger.info("Setting City - " + cityName);
        //System.out.println("Setting City - " + cityName);
        searchHotelSpan.click();
        searchHotelInput.sendKeys(cityName);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", cityName);
        driver.findElement(By.xpath(xpath)).click();
        Logger.info("! Setting City DONE !");
        //System.out.println("! Setting City DONE !" );
        return this;

    }

    public HotelSearchPage setDates(String checkIn, String checkOut) {
        Logger.info("Setting Dates checkIn: " + checkIn + " and checkOut: " + checkOut);
        //System.out.println("Setting Dates checkIn: " + checkIn + " and checkOut: " + checkOut);
        checkInImput.sendKeys(checkIn);
        checkOutInput.sendKeys(checkOut);
        Logger.info("! Setting Dates DONE !");
        //System.out.println("! Setting Dates DONE !");
        return this;
    }

    public HotelSearchPage setTravelers(int adultsToAdd, int childToAdd) {
        Logger.info("Adding Adults: " + adultsToAdd + " and Kids: " + childToAdd);
        //System.out.println("Adding Adults: " + adultsToAdd + " and Kids: " + childToAdd);
        travelersInput.click();

        addTraveler(adultPlusBtn, adultsToAdd);
        addTraveler(childPlusBtn, childToAdd);

        Logger.info("! Adding DONE !");
        //System.out.println("! Adding DONE !");
        return this;

    }

    //tworzenie metody do dodawania podróżujących
    private void addTraveler(WebElement travelerBtn, int numberofTravelers) {
        for (int i = 0; i < numberofTravelers; i++) {
            travelerBtn.click();
        }
    }

    public ResultsPage performSearch() {
        Logger.info("Performing search");
        //System.out.println("Performing search");
        searchButton.click();
        Logger.info("! Performing search DONE !");
        //System.out.println("! Performing search DONE !");
        return new ResultsPage(driver);

    }

    //metoda odpowiedzialna za znajdowanie i wejście do zakładki z rejestracją konta
    public void openSignUpForm() {
        myAccountLink.stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        signUpLink.get(1).click();

    }

}
