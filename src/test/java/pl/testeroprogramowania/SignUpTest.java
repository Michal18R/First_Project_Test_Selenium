package pl.testeroprogramowania;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.model.User;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.LoggedUserPage;
import pl.seleniumdemo.pages.SignUpPage;
import pl.seleniumdemo.tests.BaseTest;


public class SignUpTest extends BaseTest {


    @Test
    public void signUpTest() {

        String lastName = "Testowy";

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.setFirstName("Bartek");
        signUpPage.setLastName(lastName);
        signUpPage.setPhone("884343555");
        signUpPage.setEmail();
        signUpPage.setPassword("12121r1213wqsc");
        signUpPage.setConfirmPassword("12121r1213wqsc");
        signUpPage.signUpButton();


        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);

        Assert.assertTrue(loggedUserPage.getHeadingText().contains(lastName));
        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Bartek Testowy");


    }

    @Test
    public void signUpTest2() {

        String lastName = "Testowy";

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.fillSignUpForm("Piotr", lastName, "778343555", "r1213wqsc");


        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);

        Assert.assertTrue(loggedUserPage.getHeadingText().contains(lastName));
        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Piotr Testowy");

    }

    @Test
    public void signUpTest3() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);

        User user = new User();
        user.setFirstName("Karol");
        user.setLastName("Koks");
        user.setPhone("121761242");
        user.setPassword("kakaq121");

        signUpPage.fillSignUpForm2(user);

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);

        Assert.assertTrue(loggedUserPage.getHeadingText().contains(user.getLastName()));
        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Karol Koks");

    }
}
