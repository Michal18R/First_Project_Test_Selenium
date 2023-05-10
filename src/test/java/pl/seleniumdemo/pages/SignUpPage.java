package pl.seleniumdemo.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;
import java.util.stream.Collectors;

public class SignUpPage {

    //podstawa Page do działania
    public SignUpPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(name = "firstname")
    private WebElement firstNameInput;

    @FindBy(name = "lastname")
    private WebElement lastNameInput;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "confirmpassword")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[text()=' Sign Up']")
    private WebElement signUpButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']//p")
    private List<WebElement> errors;

    public WebDriver driver;

    public SignUpPage setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public SignUpPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public SignUpPage setPhone(String phone) {
        phoneInput.sendKeys(phone);
        return this;
    }

    public SignUpPage setEmail() {

        int randomNumber = (int) (Math.random() * 1000);
        String mail = "costam" + randomNumber + "@gmail.com";

        emailInput.sendKeys(mail);
        return this;
    }

    public SignUpPage setFailEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public SignUpPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public SignUpPage setConfirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
        return this;
    }

    public LoggedUserPage signUpButton() {
        signUpButton.click();
        return new LoggedUserPage(driver);
    }

    public List<String> getErrors() {
        return errors.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
