package pl.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelSearchPage {
    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private  WebElement searchHotelSpan;

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
    public HotelSearchPage(WebDriver driver){

        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void setCity(String cityName){
        searchHotelSpan.click();
        searchHotelInput.sendKeys(cityName);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", cityName);
        driver.findElement(By.xpath(xpath)).click();

    }

    public void setDates(String checkIn, String checkOut){
        checkInImput.sendKeys(checkIn);
        checkOutInput.sendKeys(checkOut);
    }

    public void setTravelers(int adultsToAdd, int childToAdd){
        travelersInput.click();

        addTraveler(adultPlusBtn, adultsToAdd);
        addTraveler(childPlusBtn, childToAdd);

    }

    //tworzenie metody do dodawania podróżujących
    private  void addTraveler (WebElement travelerBtn, int numberofTravelers){
        for (int i=0; i<numberofTravelers; i++){
            travelerBtn.click();
        }
    }

    public void performSearch(){
        searchButton.click();
    }

    //metoda odpowiedzialna za znajdowanie i wejście do zakładki z rejestracją konta
    public void openSignUpForm(){
        myAccountLink.stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        signUpLink.get(1).click();

    }

}
