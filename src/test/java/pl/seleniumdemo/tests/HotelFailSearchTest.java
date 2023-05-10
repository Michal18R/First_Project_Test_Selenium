package pl.seleniumdemo.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultsPage;


public class HotelFailSearchTest extends BaseTest {


    @Test
    public void hotelFailSearchTest() {

        ResultsPage resultsPage = new HotelSearchPage(driver)
                .setDates("27/04/2021", "29/04/2021")
                .setTravelers(0, 2)
                .performSearch();


        Assert.assertTrue(resultsPage.resultHeading.isDisplayed());
        Assert.assertEquals(resultsPage.getHeadingText(), "No Results Found");

    }
}
