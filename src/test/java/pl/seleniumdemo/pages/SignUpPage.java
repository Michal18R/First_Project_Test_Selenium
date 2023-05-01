package pl.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    //podstawa Page do działania
    public SignUpPage (WebDriver driver){
        PageFactory.initElements(driver, this);
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

    public void setFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void setPhone(String phone){
        phoneInput.sendKeys(phone);
    }

    public void setEmail(){

        int randomNumber = (int) (Math.random()*1000);
        String mail = "costam" + randomNumber + "@gmail.com";

        emailInput.sendKeys(mail);
    }

    public void setPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword){
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void signUpButton(){
        signUpButton.click();
    }


}
