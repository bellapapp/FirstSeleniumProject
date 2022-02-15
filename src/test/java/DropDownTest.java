import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropDownTest {
    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void dropdownTestSortByPosition() {
        Actions actions = new Actions(driver);
        WebElement firstMenu = driver.findElement(By.cssSelector(".nav-1 .level0.has-children"));
        actions.moveToElement(firstMenu);
        WebElement thirdSubMenu = driver.findElement(By.cssSelector(".nav-1-2 .level1"));
        actions.moveToElement(thirdSubMenu);
        actions.click().build().perform();

        WebElement sorting = driver.findElement(By.cssSelector(".category-products > .toolbar .sort-by select"));
        Select dropdown = new Select(sorting);
        dropdown.selectByVisibleText("Position");
    }

    @Test
    public void dropdownTestSortByName() {
        Actions actions = new Actions(driver);
        WebElement firstMenu = driver.findElement(By.cssSelector(".nav-1 .level0.has-children"));
        actions.moveToElement(firstMenu);
        WebElement thirdSubMenu = driver.findElement(By.cssSelector(".nav-1-2 .level1"));
        actions.moveToElement(thirdSubMenu);
        actions.click().build().perform();

        WebElement sorting = driver.findElement(By.cssSelector(".category-products > .toolbar .sort-by select"));
        Select dropdown = new Select(sorting);
        dropdown.selectByVisibleText("Name");
    }

    @Test
    public void dropdownTestSortByPrice() {
        Actions actions = new Actions(driver);
        WebElement firstMenu = driver.findElement(By.cssSelector(".nav-1 .level0.has-children"));
        actions.moveToElement(firstMenu);
        WebElement thirdSubMenu = driver.findElement(By.cssSelector(".nav-1-2 .level1"));
        actions.moveToElement(thirdSubMenu);
        actions.click().build().perform();

        WebElement sorting = driver.findElement(By.cssSelector(".category-products > .toolbar .sort-by select"));
        Select dropdown = new Select(sorting);
        dropdown.selectByVisibleText("Price");
    }

    @Test
    public void dropdownTestShow12() {
        Actions actions = new Actions(driver);
        WebElement firstMenu = driver.findElement(By.cssSelector(".nav-1 .level0.has-children"));
        actions.moveToElement(firstMenu);
        WebElement thirdSubMenu = driver.findElement(By.cssSelector(".nav-1-2 .level1"));
        actions.moveToElement(thirdSubMenu);
        actions.click().build().perform();

        WebElement sorting = driver.findElement(By.cssSelector(".category-products > .toolbar .pager select"));
        Select dropdown = new Select(sorting);
        dropdown.selectByVisibleText("12");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
