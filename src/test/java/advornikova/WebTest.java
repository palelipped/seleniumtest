package advornikova;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class WebTest {
    private ChromeDriver driver;

    private static final String FLVTO = "https://www.flvto.biz/";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-GB");

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testTermsOfUseLink() {
        driver.get(FLVTO);

        WebElement termsOfUse = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Terms of Use")));
        termsOfUse.click();
        WebElement checkTerms = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("text-center")));

        assertThat(checkTerms.getText(), containsString("Terms Of Use"));
    }

    @Test
    public void testHowToLink() {
        driver.get(FLVTO);

        WebElement howTo = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("How to")));
        howTo.click();
        WebElement checkHowTo = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".howto h1")));
        
        assertThat(checkHowTo.getText(), containsString("How to"));
    }

    @Test
    public void testPrivacyPolicy() {
        driver.get(FLVTO);

        WebElement howTo = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Privacy Policy")));
        howTo.click();
        WebElement checkHowTo = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("text-center")));

        assertThat(checkHowTo.getText(), containsString("Privacy Policy"));
    }

    @Test
    public void testDMCA() {
        driver.get(FLVTO);

        WebElement howTo = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("DMCA")));
        howTo.click();
        WebElement checkHowTo = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".feedback h1")));

        assertThat(checkHowTo.getText(), containsString("DMCA Form"));
    }

    @Test
    public void testFeedback() {
        driver.get(FLVTO);

        WebElement howTo = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Feedback")));
        howTo.click();
        WebElement checkHowTo = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".feedback h1")));

        assertThat(checkHowTo.getText(), containsString("Feedback"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
