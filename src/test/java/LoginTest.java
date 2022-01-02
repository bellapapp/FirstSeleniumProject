import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest {
    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void loginWithValidCredentials() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".skip-content.skip-active li:last-child a")).click();
        driver.findElement(By.id("email")).sendKeys("bellatest@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();

        Assert.assertFalse(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
    }

    @Test
    public void loginWithNotRegisteredEmail() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".skip-content.skip-active li:last-child a")).click();
        driver.findElement(By.id("email")).sendKeys("bellatest1000@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
        Assert.assertTrue(driver.findElement(By.cssSelector(".account-login .error-msg")).isDisplayed());
        Assert.assertEquals("Invalid login or password.", driver.findElement(By.cssSelector(".account-login .error-msg")).getText());
    }

    @Test
    public void loginWithInvalidEmailFormat() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".skip-content.skip-active li:last-child a")).click();
        driver.findElement(By.id("email")).sendKeys("bellatest1000mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());

    }

    @Test
    public void LoginWithInvalidPassword() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".skip-content.skip-active li:last-child a")).click();
        driver.findElement(By.id("email")).sendKeys("bellatest1000@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("12345678");
        driver.findElement(By.id("send2")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
        Assert.assertTrue(driver.findElement(By.cssSelector(".account-login .error-msg")).isDisplayed());
        Assert.assertEquals("Invalid login or password.", driver.findElement(By.cssSelector(".account-login .error-msg")).getText());
    }

    @Test
    public void LoginWithoutEmail() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".skip-content.skip-active li:last-child a")).click();
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
        Assert.assertFalse(driver.findElements(By.cssSelector("#advice-required-entry-email")).isEmpty());
    }

    @Test
    public void LoginWithoutPassword() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".skip-content.skip-active li:last-child a")).click();
        driver.findElement(By.id("email")).sendKeys("bellatest1000@mailinator.com");
        driver.findElement(By.id("send2")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
        Assert.assertFalse(driver.findElements(By.cssSelector("#advice-required-entry-pass")).isEmpty());
    }

    @Test
    public void LoginWithEmptyFields() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".skip-content.skip-active li:last-child a")).click();
        driver.findElement(By.id("send2")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
        Assert.assertFalse(driver.findElements(By.cssSelector("#advice-required-entry-pass")).isEmpty());
        Assert.assertFalse(driver.findElements(By.cssSelector("#advice-required-entry-email")).isEmpty());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
