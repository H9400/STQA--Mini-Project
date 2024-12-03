package FirstProject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Mouthshut {
    WebDriver driver;

    public Mouthshut() {
        // Set ChromeDriver system property
        System.setProperty("webdriver.chrome.driver", "D:\\Crome\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create preferences to disable notifications
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);

        // Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // Initialize ChromeDriver with options
        driver = new ChromeDriver(options);

        // Set implicit wait time
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        // Open a target URL (example: Mouthshut website)
        driver.get("https://www.mouthshut.com/");
        driver.manage().window().maximize();
    }

    public void searchAndCollectReviews() {
        try {
            // Example search for a product or service
            WebElement searchBox = driver.findElement(By.name("search"));
            searchBox.sendKeys("Aditya Birla Memorial Hospital");
            searchBox.submit();

            // Wait and collect reviews
            List<WebElement> reviews = driver.findElements(By.className("review-section"));

            // Create a PrintWriter to write reviews to a file
            PrintWriter writer = new PrintWriter("Feedback_All_Pages.txt", "UTF-8");

            for (WebElement review : reviews) {
                String reviewText = review.getText();
                System.out.println("Review: " + reviewText);

                // Save each review to the file
                writer.println(reviewText);
            }

            writer.close();  // Close the PrintWriter after writing

        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        Mouthshut mouthshut = new Mouthshut();
        mouthshut.searchAndCollectReviews();
    }
}
