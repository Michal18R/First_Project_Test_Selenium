package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.tests.BaseTest;

public class HotelFailSearchTest extends BaseTest {


    @Test
    public void hotelFailSearchTest(){

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

    }
}
