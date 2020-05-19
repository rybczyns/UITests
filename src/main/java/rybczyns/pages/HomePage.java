package rybczyns.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class HomePage extends SeleniumPage {
    final String successIdInTest = "1";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search-input")
    private WebElement searchBox;
    @FindBy(xpath = "//table[contains(@class, 'table-hover')]/tbody/tr[1]/td[1]")
    private WebElement idColumnInTbody;
    @FindBy(xpath = "//table[contains(@class, 'table-hover')]/tbody/tr[1]/td[2]")
    private WebElement nameColumnInTbody;


    public HomePage enterText(String inputText) {

        searchBox.sendKeys(inputText);
        return this;
    }

    public HomePage assertSearchResults(String text) {

        boolean result = idColumnInTbody.getText().equals(successIdInTest) &&
                nameColumnInTbody.getText().equals(text);
        Assert.assertTrue(result);

        return this;
    }

}
