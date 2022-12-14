import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class homeworkk {

    public static WebDriver driver;

    @BeforeClass
    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Step("Step1")
    public void WebDriverHelloWorldTest() throws InterruptedException {
        driver.get("https://yandex.com/");
        Thread.sleep(1000);
        //WebElement waitSearchfield = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='text']\"")));
        //System.out.println(waitSearchfield.getText());
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement search = driver.findElement(By.xpath("//input[@id='text']"));
        search.sendKeys("Intel Core i9");
        //Thread.sleep(1000);

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/table/tbody/tr[2]/td[2]/form/div[2]/button"));
        searchButton.click();
        //Thread.sleep(1000);

        WebElement advancedSearch = driver.findElement(By.xpath("/html/body/header/div/div/div[3]/form/div[1]/span/span/button"));
        advancedSearch.click();
        WebElement waitSearchfield = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/form/div[2]/div/label[2]/input")));

        WebElement englishLanguage = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/form/div[2]/div/label[2]/input"));
        englishLanguage.click();
        WebElement pastMonth = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/form/div[1]/div[2]/span/label[3]"));
        pastMonth.click();
        WebElement searchBut = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/form/div[3]/button"));
        searchBut.click();
        Thread.sleep(1000);

        WebElement link = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[1]/ul/li[1]/div/div[1]/a/h2/span"));
        link.click();

    }

    @AfterClass
    public static void screenshot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            Allure.addAttachment("",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            //driver.quit();
        }
    }
}

