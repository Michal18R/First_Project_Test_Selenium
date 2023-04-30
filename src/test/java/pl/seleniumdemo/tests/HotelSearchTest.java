package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultsPage;

import java.util.List;
import java.util.stream.Collectors;

public class HotelSearchTest extends BaseTest {



    @Test
    public void searchHotelTest() throws InterruptedException {


        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity("Dubai");
        hotelSearchPage.setDates("27/04/2021", "29/04/2021");
        hotelSearchPage.setTravelers();
        hotelSearchPage.performSearch();


        ResultsPage resultsPage = new ResultsPage(driver);

        //pobieranie nazw hoteli do listy
        List<String> hotelNames = resultsPage.getHotelNames();

        hotelNames.forEach(System.out::println);

        //Assercje
        Assert.assertEquals("Jumeirah Beach Hotel",hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower",hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana",hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth",hotelNames.get(3));



    }
}
