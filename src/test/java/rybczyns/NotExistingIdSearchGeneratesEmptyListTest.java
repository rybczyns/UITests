package rybczyns;

import org.testng.annotations.Test;
import rybczyns.pages.HomePage;

public class NotExistingIdSearchGeneratesEmptyListTest extends SeleniumBaseTest {
    final String columnName = "Id";

    @Test
    public void noIdGeneratesEmptyTable() {
        new HomePage(driver)
                .selectIdFromList(columnName)
                .enterText("0")
                .assertNoResultsDisplayed();
    }
}
