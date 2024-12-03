package site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor; // <-- Add this import
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class Mouthshut {

    WebDriver driver;

    // Constructor to set up WebDriver and navigate to the website
    public Mouthshut() {
        // Set the system property for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\Crome\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create options to disable notifications in Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // Initialize the ChromeDriver with options
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // Method to collect reviews from the JustDial page and save them to a text file
    public void collectReviews() {
        try {
            // Open the given URL
            driver.get("https://www.justdial.com/Nashik/SNJB-s-Late-Sau-Kantabai-Bhavarlalji-Jain-College-Of-Engineering-Neminagar-Chandwad/0253PX253-X253-151019113056-B2P9_BZDET/reviews/page-6");

            // Wait for the reviews section to load using explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'review')]")));

            // Scroll down the page to ensure reviews are loaded
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");

            // Wait for a moment after scrolling for reviews to load
            Thread.sleep(2000);

            // Open the file to save the reviews at the specified path
            FileWriter writer = new FileWriter("E:/eclipse_workspace/Selenium/Snjb.txt", true);

            // Find the review elements by XPath
            List<WebElement> reviews = driver.findElements(By.xpath("//div[contains(@class, 'review')]"));

            // Debugging: Check if reviews are found
            System.out.println("Found " + reviews.size() + " reviews.");

            // Loop through the reviews and extract the text
            for (WebElement review : reviews) {
                // Extract the review text
                String reviewText = review.getText();
                System.out.println("Review: " + reviewText);

                // Write the review text to the file
                writer.write(reviewText + "\n");
            }

            // Close the file writer after all reviews have been saved
            writer.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    // Main method to execute the script
    public static void main(String[] args) {
        Mouthshut Mouthshut = new Mouthshut();
        Mouthshut.collectReviews();  // Collect reviews and save to the text file
    }
}
