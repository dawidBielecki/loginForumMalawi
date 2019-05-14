package DataPacked;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class DefaultTest {

    public static WebDriver driver;

    @BeforeTest()
    public void beforeTest(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dave\\Desktop\\time hacking\\testing stuff\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit. SECONDS);
        driver.get("http://forum.klub-malawi.pl");

    }

    @AfterTest()
    public  void afterTest(){
        driver.quit();
    }



}
