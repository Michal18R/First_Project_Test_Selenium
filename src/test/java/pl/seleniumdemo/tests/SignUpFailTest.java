package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.tests.BaseTest;

import java.util.List;
import java.util.stream.Collectors;

public class SignUpFailTest extends BaseTest {

    @Test
    public void signUpFailTest() {


        //otwieranie zakładtki z tworzeniem konta
        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        List<String> Errors = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p")).stream().map(WebElement::getText)
                .collect(Collectors.toList());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Errors.contains("The Email field is required."));
        softAssert.assertTrue(Errors.contains("The Password field is required."));
        softAssert.assertTrue(Errors.contains("The Password field is required."));
        softAssert.assertTrue(Errors.contains("The First name field is required."));
        softAssert.assertTrue(Errors.contains("The Last Name field is required."));
        softAssert.assertAll();

        }


        @Test
        public void signUpFailTest2(){

            //otwieranie zakładtki z tworzeniem konta
            driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
            driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();


            //wypełnianie pól do rejestracji
            driver.findElement(By.name("firstname")).sendKeys("Karol");
            driver.findElement(By.name("lastname")).sendKeys("Koks");
            driver.findElement(By.name("phone")).sendKeys("884333998");
            driver.findElement(By.name("email")).sendKeys("koksy.pl");
            driver.findElement(By.name("password")).sendKeys("koksytamm");
            driver.findElement(By.name("confirmpassword")).sendKeys("koksytamm");
            driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

            List<String> Errors = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p")).stream().map(WebElement::getText)
                    .collect(Collectors.toList());

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(Errors.contains("The Email field must contain a valid email address."));
            softAssert.assertAll();

        }


}