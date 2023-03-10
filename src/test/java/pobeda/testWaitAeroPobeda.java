package pobeda;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class testWaitAeroPobeda {
    WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\User\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get("https://google.com");
        driver.manage().window().maximize();
    }
    @Test
    public void openPobedaPage() {
        //Открытие в Google первой ссылки по запросу "Сайт компании Победа"
        driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).click();
        driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).sendKeys("Сайт компании Победа");
        driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("h3")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://pobeda.aero/");
        //Ожидание появления картинки "Полетели в Санкт-Петербург"

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"dp-an0f92\"]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Полетели в Санкт-Петербург!\"]")));
// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[class=\"dp-an0f92\"]"))));
        driver.findElement(By.xpath("//*[text()=\"Полетели в Санкт-Петербург!\"]")).isDisplayed();
        driver.findElement(By.cssSelector("[class=\"dp-an0f92\"]")).isDisplayed();
        String text = driver.findElement(By.xpath("//*[text()=\"Полетели в Санкт-Петербург!\"]")).getText();
        Assert.assertEquals("Полетели в Санкт-Петербург!", text);
        //Переключение языка на английский
        WebElement langButton = driver.findElement(By.id("mantine-R6md6eqm-target"));
        langButton.click();
// driver.findElement(By.cssSelector("[class=\"dp-o0jqr4\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"dp-1ivsjgz\"]")));
        driver.findElements(By.cssSelector("[class=\"dp-1ivsjgz\"]")).get(1).click();


        driver.findElement(By.cssSelector("#id LanguageSelector .ui-dropdown_value_name")).click();
        driver.findElement(By.cssSelector("idLanguageSelector-0")).click();
       // wait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.cssSelector(".main-header-primary li:nth-child(1)")), "Ticket search"));
       // wait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.cssSelector(".main-header-primary li:nth-child(2)")),"Online check-in"));
       // wait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.cssSelector(".main-header-primary li:nth-child(3)")),"Manage my booking"));


       // WebElement ticketSrch = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div/div[2]/div/div[1]/div[2]/button[1]/div[2]"));
       WebElement ticketSrch = driver.findElement(By.xpath("//*[contains(@class,\"dp-wfavxc\") and text()=\"Ticket search\"]"));
       wait.until(ExpectedConditions.textToBePresentInElement(ticketSrch, "Ticket search"));
       // WebElement checkIn = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div/div[2]/div/div[1]/div[2]/button[2]/div[2]"));
       // WebElement checkIn = driver.findElement(By.xpath("//*[contains(@class,'mantine') and text()='Online check-in']"));
       //wait.until(ExpectedConditions.textToBePresentInElement(checkIn, "Online check-in"));
        //WebElement manageMyBooking = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div/div[2]/div/div[1]/div[2]/button[3]/div[2]"));
       //WebElement manageMyBooking = driver.findElement(By.xpath("//*[contains(@class,'mantine') and text()='Manage my booking']"));
       //wait.until(ExpectedConditions.textToBePresentInElement(manageMyBooking, "Manage my booking"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}