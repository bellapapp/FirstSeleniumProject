import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Locale;

public class CartTest {

    WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addToCartWithoutLogin() {
        WebElement nav1 = driver.findElement(By.cssSelector(".nav-1 .has-children"));
        Actions actions = new Actions(driver);
        actions.moveToElement(nav1);
        WebElement sub3 = driver.findElement(By.cssSelector(".nav-1-2 a"));
        actions.moveToElement(sub3);
        actions.click().build().perform();
        driver.findElement(By.cssSelector(".category-products .item:first-child .actions .button")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_color li:first-child a")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_size li:nth-child(2) a")).click();

        String productTitle = driver.findElement(By.cssSelector(".product-view .product-name span")).getText();

        driver.findElement(By.cssSelector(".add-to-cart .btn-cart")).click();

        String cartSuccessMsg = driver.findElement(By.cssSelector(".success-msg")).getText();

        List<WebElement> cartProductTitleList = driver.findElements(By.cssSelector("#shopping-cart-table tbody .product-name a"));

        boolean isProductTitleFoundInCart = false;
        for (WebElement cartProductTitleElement : cartProductTitleList) {
            if (cartProductTitleElement.getText().equals(productTitle)) {
                isProductTitleFoundInCart = true;
                break;
            }
        }
        Assert.assertEquals((productTitle + " was added to your shopping cart.").toLowerCase(), cartSuccessMsg.toLowerCase());
        Assert.assertTrue(isProductTitleFoundInCart);
    }

    @Test
    public void addToCartWithLogin() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".skip-content.skip-active li:last-child a")).click();
        driver.findElement(By.id("email")).sendKeys("bellatest@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement nav1 = driver.findElement(By.cssSelector(".nav-1 .has-children"));
        Actions actions = new Actions(driver);
        actions.moveToElement(nav1);
        WebElement sub3 = driver.findElement(By.cssSelector(".nav-1-2 a"));
        actions.moveToElement(sub3);
        actions.click().build().perform();
        driver.findElement(By.cssSelector(".category-products .item:first-child .actions .button")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_color li:first-child a")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_size li:nth-child(2) a")).click();

        String productTitle = driver.findElement(By.cssSelector(".product-view .product-name span")).getText();

        driver.findElement(By.cssSelector(".add-to-cart .btn-cart")).click();

        String cartSuccessMsg = driver.findElement(By.cssSelector(".success-msg")).getText();

        List<WebElement> cartProductTitleList = driver.findElements(By.cssSelector("#shopping-cart-table tbody .product-name a"));

        boolean isProductTitleFoundInCart = false;
        for (WebElement cartProductTitleElement : cartProductTitleList) {
            if (cartProductTitleElement.getText().equals(productTitle)) {
                isProductTitleFoundInCart = true;
                break;
            }
        }
        Assert.assertEquals((productTitle + " was added to your shopping cart.").toLowerCase(), cartSuccessMsg.toLowerCase());
        Assert.assertTrue(isProductTitleFoundInCart);
    }

    @Test
    public void TryToAddToCartMoreQtyThanAreAvailable() {
        driver.findElement(By.cssSelector(".nav-6 .level0")).click();
        driver.findElement(By.cssSelector(".category-products .item:nth-child(3) .actions .button")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_color li:nth-child(2) a")).click();
        driver.findElement(By.cssSelector("#qty")).clear();
        driver.findElement(By.cssSelector("#qty")).sendKeys("10000");

        String productTitle = driver.findElement(By.cssSelector(".product-view .product-name span")).getText();
        driver.findElement(By.cssSelector(".add-to-cart .btn-cart")).click();

        WebElement errorMsg = driver.findElement(By.cssSelector(".error-msg span"));

        Assert.assertTrue(errorMsg.isDisplayed());

        String errorMessage = errorMsg.getText().toLowerCase();

        Assert.assertEquals(("The requested quantity for \"" + productTitle + "\" is not available.").toLowerCase(), errorMessage);

    }

    @Test
    public void TryToAddToCartTooMuchQty() {
        driver.findElement(By.cssSelector(".nav-6 .level0")).click();
        driver.findElement(By.cssSelector(".category-products .item:nth-child(3) .actions .button")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_color li:nth-child(2) a")).click();
        driver.findElement(By.cssSelector("#qty")).clear();
        driver.findElement(By.cssSelector("#qty")).sendKeys("10001");

        driver.findElement(By.cssSelector(".add-to-cart .btn-cart")).click();

        WebElement errorMsg = driver.findElement(By.cssSelector(".error-msg span"));

        Assert.assertTrue(errorMsg.isDisplayed());

        String errorMessage = errorMsg.getText();

        Assert.assertEquals(("The maximum quantity allowed for purchase is 10000."), errorMessage);
    }
}
