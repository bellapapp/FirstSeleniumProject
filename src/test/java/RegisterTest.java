import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegisterTest {

    public void registerWithValidDates() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Bella");
        driver.findElement(By.id("lastname")).sendKeys("Papp");
        driver.findElement(By.id("email_address")).sendKeys("bellatest12@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        driver.quit();
    }

    public void registerWithRegisteredEmailAddress() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Bella");
        driver.findElement(By.id("lastname")).sendKeys("Papp");
        driver.findElement(By.id("email_address")).sendKeys("bellatest@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        driver.quit();
    }

    public void registerWithoutFillingARequiredField() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Bella");
        driver.findElement(By.id("lastname")).sendKeys("Papp");
        driver.findElement(By.id("email_address")).sendKeys("bellatest26@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        driver.quit();

    }

    public void registerWithInvalidEmailAddress() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Bella");
        driver.findElement(By.id("lastname")).sendKeys("Papp");
        driver.findElement(By.id("email_address")).sendKeys("bellatest26mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        driver.quit();

    }

    public void registerWithDifferentPasswords() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Bella");
        driver.findElement(By.id("lastname")).sendKeys("Papp");
        driver.findElement(By.id("email_address")).sendKeys("bellatest26@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("1234567");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        driver.quit();

    }
}
