package rybczyns;

import org.testng.annotations.Test;
import rybczyns.pages.HomePage;

public class searchForCityWithMatchCaseShowsResultsTest extends SeleniumBaseTest {
    final String columnName="City";
    final String searchCity="Melbourne";
    @Test
    public void enteredCityExistsInResultTable(){
        new HomePage(driver)
        .selectColumnFromList(columnName)
        .enterText(searchCity)
        .matchCaseEnabled(true)
        .assertMatchCaseGeneratesResults(searchCity);
    }
}
