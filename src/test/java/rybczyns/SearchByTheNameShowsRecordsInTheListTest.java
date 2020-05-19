package rybczyns;

import org.testng.annotations.Test;
import rybczyns.pages.HomePage;

public class SearchByTheNameShowsRecordsInTheListTest extends SeleniumBaseTest {

    @Test
    public void searchByTheName(){
        String searchName = "Alabaster";

        new HomePage(driver)
                .enterText(searchName)
                .assertSearchResults(searchName);
    }
}
