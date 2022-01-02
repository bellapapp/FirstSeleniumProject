import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegisterTest {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void registerWithValidDates() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("#header-account .links li:nth-child(5) a")).click();
        driver.findElement(By.id("firstname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("lastname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("email_address")).sendKeys(RandomStringUtils.randomAlphabetic(6) + "@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate .buttons-set .button")).click();

        Assert.assertFalse(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
    }

    @Test
    public void registerWithRegisteredEmailAddress() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("#header-account .links li:nth-child(5) a")).click();
        driver.findElement(By.id("firstname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("lastname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("email_address")).sendKeys("bellatest@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("confirmation")).sendKeys("12345678");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate .buttons-set .button")).click();

        String errorMsg = driver.findElement(By.cssSelector(".account-create .error-msg span")).getText();

        Assert.assertTrue(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
        Assert.assertTrue(errorMsg.contains("There is already an account with this email address."));
    }

    @Test
    public void registerWithInvalidEmailAddressFormat() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("#header-account .links li:nth-child(5) a")).click();
        driver.findElement(By.id("firstname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("lastname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("email_address")).sendKeys(RandomStringUtils.randomAlphanumeric(6) +"mailinator.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("confirmation")).sendKeys("12345678");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate .buttons-set .button")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
    }


    @Test
    public void registerWithoutFillingARequiredField() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("#header-account .links li:nth-child(5) a")).click();
        driver.findElement(By.id("lastname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("email_address")).sendKeys(RandomStringUtils.randomAlphabetic(6) + "@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate .buttons-set .button")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
        Assert.assertFalse(driver.findElements(By.cssSelector(".validation-advice")).isEmpty());
    }


    @Test
    public void registerWithoutPasswords() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("#header-account .links li:nth-child(5) a")).click();
        driver.findElement(By.id("firstname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("lastname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("email_address")).sendKeys(RandomStringUtils.randomAlphabetic(6) + "@mailinator.com");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate .buttons-set .button")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
        Assert.assertFalse(driver.findElements(By.cssSelector("#advice-required-entry-password")).isEmpty());
        Assert.assertFalse(driver.findElements(By.cssSelector("#advice-required-entry-confirmation")).isEmpty());
    }

    @Test
    public void registerWithDifferentPasswords() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("#header-account .links li:nth-child(5) a")).click();
        driver.findElement(By.id("firstname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("lastname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("email_address")).sendKeys(RandomStringUtils.randomAlphabetic(6) + "@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123457");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate .buttons-set .button")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
        Assert.assertFalse(driver.findElements(By.cssSelector("#advice-validate-cpassword-confirmation")).isEmpty());
    }

    @Test
    public void registerWith1CharacterPasswords() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("#header-account .links li:nth-child(5) a")).click();
        driver.findElement(By.id("firstname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("lastname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("email_address")).sendKeys(RandomStringUtils.randomAlphabetic(6) + "@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("1");
        driver.findElement(By.id("confirmation")).sendKeys("1");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate .buttons-set .button")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
        Assert.assertFalse(driver.findElements(By.cssSelector("#advice-validate-password-password")).isEmpty());
    }

    @Test
    public void registerWith5CharacterPasswords() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("#header-account .links li:nth-child(5) a")).click();
        driver.findElement(By.id("firstname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("lastname")).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.id("email_address")).sendKeys(RandomStringUtils.randomAlphabetic(6) + "@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("confirmation")).sendKeys("12345");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate .buttons-set .button")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
        Assert.assertFalse(driver.findElements(By.cssSelector("#advice-validate-password-password")).isEmpty());
    }

    @Test
    public void registerWithoutFillingAllFields() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("#header-account .links li:nth-child(5) a")).click();
        driver.findElement(By.cssSelector("#form-validate .buttons-set .button")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".my-account .dashboard")).isEmpty());
        Assert.assertFalse(driver.findElements(By.cssSelector(".validation-advice")).isEmpty());
    }

}
