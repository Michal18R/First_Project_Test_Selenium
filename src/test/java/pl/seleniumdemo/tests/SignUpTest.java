package pl.seleniumdemo.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.LoggedUserPage;
import pl.seleniumdemo.pages.SignUpPage;


public class SignUpTest extends BaseTest {


    @Test
    public void signUpTest(){

        String lastName = "Testowy";

        LoggedUserPage loggedUserPage = new HotelSearchPage(driver)
                .openSignUpForm()
                .setFirstName("Bartek")
                .setLastName(lastName)
                .setPhone("884343555")
                .setEmail()
                .setPassword("12121r1213wqsc")
                .setConfirmPassword("12121r1213wqsc")
                .signUpButton();

        Assert.assertTrue(loggedUserPage.getHeadingText().contains(lastName));
        Assert.assertEquals(loggedUserPage.getHeadingText(),"Hi, Bartek Testowy");

    }
}
