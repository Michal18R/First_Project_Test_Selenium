import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpTest extends BaseTest{


    @Test
    public void signUpTest(){


        //otwieranie zakładtki z tworzeniem konta
        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();

        int randomNumber = (int) (Math.random()*1000);
        String mail = "costam" + randomNumber + "@gmail.com";

        //wypełnianie pól do rejestracji
        driver.findElement(By.name("firstname")).sendKeys("Karol");
        driver.findElement(By.name("lastname")).sendKeys("Koks");
        driver.findElement(By.name("phone")).sendKeys("884333998");
        driver.findElement(By.name("email")).sendKeys(mail);
        driver.findElement(By.name("password")).sendKeys("koksytamm");
        driver.findElement(By.name("confirmpassword")).sendKeys("koksytamm");
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();


        //pobieranie treści główka
        WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));

        String lastName = "Testowy";
        Assert.assertFalse(heading.getText().contains(lastName));
        Assert.assertEquals(heading.getText(),"Hi, Karol Koks");



    }
}
