package rybczyns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class SeleniumBaseTest {

    protected WebDriver driver;
    final String url= "src\\main\\resources\\Output\\index.html";

    @BeforeMethod
    public void baseBeforeMethod() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "libs\\chromedriver.exe");
        driver = new ChromeDriver(); //TODO locate driver by system
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        Path urlToIndex = Paths.get(url);
        driver.get(urlToIndex.toUri().toString());
//        driver.get(url);
    }

    @AfterMethod
    public void baseAfterMethod(){
        driver.quit();
    }


}
