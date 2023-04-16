import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

        protected WebDriver driver;

        @BeforeMethod
        public void setup(){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.get("http://www.kurs-selenium.pl/demo/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
    }

