package FirstProject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpenSite {
    WebDriver driver;

    public OpenSite() {
        // Set ChromeDriver system property
        System.setProperty("webdriver.chrome.driver", "D:\\Crome\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create preferences to disable notifications
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // Initialize ChromeDriver with options
        driver = new ChromeDriver(options);
        
        // Set implicit wait time
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        // Open the URL
        driver.get("https://www.facebook.com/");
        
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    public static void main(String[] args) {
        // Create an instance of Opensite to run the setup
        new OpenSite();
    }
}
