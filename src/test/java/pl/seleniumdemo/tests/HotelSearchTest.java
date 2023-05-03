package pl.seleniumdemo.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultsPage;

import java.util.List;


public class HotelSearchTest extends BaseTest {



    @Test
    public void searchHotelTest() throws InterruptedException {


        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity("Dubai");
        hotelSearchPage.setDates("27/04/2021", "29/04/2021");
        hotelSearchPage.setTravelers(2,2);
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

    @Test
    public void searchHotelTest2() throws InterruptedException {


        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        List<String> hotelNames = hotelSearchPage.setCity("Dubai")
                                  .setDates("27/04/2021", "29/04/2021")
                                  .setTravelers(2,2)
                                  .performSearch().getHotelNames();


        hotelNames.forEach(System.out::println);

        //Assercje
        Assert.assertEquals("Jumeirah Beach Hotel",hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower",hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana",hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth",hotelNames.get(3));



    }
}
