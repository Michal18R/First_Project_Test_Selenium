import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HotelFailSearch {
    @Test
    public void hotelFailSearch(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.name("checkin")).sendKeys("17.04.2021");
        driver.findElement(By.name("checkout")).click();

        //wyszukiwanie elementu który jest widoczny na kalendarzu
        driver.findElements(By.xpath("//td[@class='day ' and text()='30']"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);

        //ustawianie ilości ludzi
        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("adultPlusBtn")).click();
        driver.findElement(By.id("childPlusBtn")).click();

        driver.findElement(By.xpath("//button[text()=' Search']")).click();


        WebElement heading = driver.findElement(By.xpath("//h2[@class='text-center']"));
        Assert.assertTrue(heading.isDisplayed());
        Assert.assertEquals(heading.getText(),"No Results Found");

        driver.quit();
    }
}
