package pl.seleniumdemo.tests;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.SignUpPage;


import java.util.List;


public class SignUpFailTest extends BaseTest {

    @Test
    public void signUpFailTest() {


        SignUpPage signUpPage = new HotelSearchPage(driver)
                .openSignUpForm();

        signUpPage.signUpButton();


        List<String> errors = signUpPage.getErrors();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errors.contains("The Email field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The First name field is required."));
        softAssert.assertTrue(errors.contains("The Last Name field is required."));
        softAssert.assertAll();

        }


        @Test
        public void signUpFailTest2(){


            SignUpPage signUpPage = new HotelSearchPage(driver)
                    .openSignUpForm()
                    .setFirstName("Michał")
                    .setLastName("Test")
                    .setPhone("884343566")
                    .setFailEmail("koksy.pl")
                    .setPassword("12121r1213wq")
                    .setConfirmPassword("12121r1213wq");
            signUpPage.signUpButton();

            List<String> errors = signUpPage.getErrors();

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(errors.contains("The Email field must contain a valid email address."));
            softAssert.assertAll();

        }


}
