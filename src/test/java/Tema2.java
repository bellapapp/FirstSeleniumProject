import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tema2 {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void searchButton() {
        driver.findElement(By.id("search")).sendKeys("top");
        driver.findElement(By.cssSelector("#search_mini_form .search-button")).click();
    }

    @Test
    public void deleteFirstFromCart() {
        driver.findElement(By.id("search")).sendKeys("top");
        driver.findElement(By.cssSelector("#search_mini_form .search-button")).click();
        driver.findElement(By.cssSelector(".category-products .item:nth-child(2) .actions .button")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_color li:first-child a")).click();
        driver.findElement(By.cssSelector(("#configurable_swatch_size li:first-child a"))).click();
        driver.findElement(By.cssSelector(".add-to-cart .btn-cart")).click();
        Actions actions = new Actions(driver);
        WebElement nav1 = driver.findElement(By.cssSelector(".nav-1 .has-children"));
        actions.moveToElement(nav1);
        WebElement sub2 = driver.findElement(By.cssSelector(".nav-1-1 a"));
        actions.moveToElement(sub2);
        actions.click().build().perform();
        driver.findElement(By.cssSelector(".category-products .item:nth-child(1) .actions .button")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_color li:first-child a")).click();
        driver.findElement(By.cssSelector(("#configurable_swatch_size li:nth-child(2) a"))).click();
        driver.findElement(By.cssSelector(".add-to-cart .btn-cart")).click();
        driver.findElement(By.cssSelector("#shopping-cart-table tbody tr:first-child .product-cart-remove .btn-remove")).click();
    }

    @Test
    public void proceedToCheckoutDown() {
        driver.findElement(By.cssSelector(".nav-5 > a")).click();
        driver.findElement(By.cssSelector(".category-products .item:first-child .actions .button")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_color li:first-child a")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_size li:first-child a")).click();
        driver.findElement(By.cssSelector(".add-to-cart .btn-cart")).click();
        driver.findElement(By.cssSelector(".checkout-types.bottom .btn-checkout")).click();
    }

    @Test
    public void selectTopSortBy() {
        driver.findElement(By.cssSelector(".nav-5 a")).click();
        WebElement positionUp = driver.findElement(By.cssSelector(".category-products > .toolbar .sort-by select"));
        Select dropdown = new Select(positionUp);
        dropdown.selectByVisibleText("Price");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
