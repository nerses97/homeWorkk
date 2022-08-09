import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testautomation {

    public static WebDriver driver;

    @BeforeClass
    public static void initWebDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void WebDriverHelloWorldTest() throws InterruptedException {
        driver.get("https://testautomationu.applitools.com/");
        Thread.sleep(1000);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement search = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[3]/div[1]/div/div[4]/div/div[2]/div[1]/div/div/div[1]/input"));
        search.sendKeys("Selenium");
        Thread.sleep(1000);

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/table/tbody/tr[2]/td[2]/form/div[2]/button"));
        searchButton.click();
        Thread.sleep(1000);

        WebElement advancedSearch = driver.findElement(By.xpath("/html/body/header/div/div/div[3]/form/div[1]/span/span/button"));
        advancedSearch.click();
        Thread.sleep(1000);

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
    public static void afterClass(){
        //driver.quit();
    }
}


