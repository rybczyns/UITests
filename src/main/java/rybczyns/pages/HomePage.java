package rybczyns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class HomePage extends SeleniumPage {
    final String successIdInTest = "1";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search-input")
    private WebElement searchInput;
    @FindBy(xpath = "//table[contains(@class, 'table-hover')]/tbody/tr[1]/td[1]")
    private WebElement idColumnInTbody;
    @FindBy(xpath = "//table[contains(@class, 'table-hover')]/tbody/tr[1]/td[2]")
    private WebElement nameColumnInTbody;
    @FindBy (id ="table-resume")
    private WebElement tableResume;


    public HomePage enterText(String inputText) {

        searchInput.sendKeys(inputText);
        return this;
    }

    public HomePage assertSearchResults(String text) {

        boolean result = idColumnInTbody.getText().equals(successIdInTest) &&
                nameColumnInTbody.getText().equals(text);
        Assert.assertTrue(result);

        return this;
    }
    public HomePage selectIdFromList(String columnName){
        Select searchColumn = new Select(driver.findElement(By.id("search-column")));
        searchColumn.selectByVisibleText(columnName);
        return this;
    }
    public HomePage assertNoResultsDisplayed(){
        Assert.assertTrue(tableResume.getText().contains("Showing 0 of "));
        return this;
    }

}
