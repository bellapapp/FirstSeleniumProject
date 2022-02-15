import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Locale;

public class WishListTest {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addToWishlistFromTheProductPageWithoutLogin() {
        driver.findElement(By.cssSelector(".nav-5 > a")).click();
        driver.findElement(By.cssSelector(".category-products .item:first-child .link-wishlist")).click();

        Assert.assertTrue(driver.findElement(By.id("login-form")).isDisplayed());
    }

    @Test
    public void addToWishlistTheCategoryProductsPageWithoutLoginFrom() {
        driver.findElement(By.cssSelector(".nav-5 > a")).click();
        driver.findElement(By.cssSelector(".category-products .item:first-child .actions .button")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();

        Assert.assertTrue(driver.findElement(By.id("login-form")).isDisplayed());
    }

    @Test
    public void addToWishlistANonSpecifiedProductFromTheProductPage() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".skip-content.skip-active li:last-child a")).click();
        driver.findElement(By.id("email")).sendKeys("bellatest@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".nav-5 > a")).click();
        driver.findElement(By.cssSelector(".category-products .item:first-child .actions .button")).click();

        String productTitle = driver.findElement(By.cssSelector(".product-view .product-name span")).getText();

        driver.findElement(By.cssSelector(".link-wishlist")).click();

        String wishlistSuccessMsg = driver.findElement(By.cssSelector(".success-msg")).getText();

        List<WebElement> wishlistProductTitleList = driver.findElements(By.cssSelector("#wishlist-table tbody .product-name a"));

        boolean isProductTitleFoundInWishlist = false;
        for (WebElement wishlistProductTitleElement : wishlistProductTitleList) {
            if (wishlistProductTitleElement.getText().equals(productTitle)) {
                isProductTitleFoundInWishlist = true;
                break;
            }
        }
        Assert.assertEquals((productTitle + " has been added to your wishlist. Click here to continue shopping.").toLowerCase(), wishlistSuccessMsg.toLowerCase());

        Assert.assertTrue(isProductTitleFoundInWishlist);

        driver.findElement(By.cssSelector("#wishlist-table tbody tr:first-child .btn-remove")).click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void addToWishlistANonSpecifiedProductFromTheCategoryProductsPage() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".skip-content.skip-active li:last-child a")).click();
        driver.findElement(By.id("email")).sendKeys("bellatest@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".nav-5 > a")).click();
        String productTitle = driver.findElement(By.cssSelector(".category-products .item:first-child .product-name a")).getText();

        driver.findElement(By.cssSelector(".category-products .item:first-child .link-wishlist")).click();

        String wishlistSuccessMsg = driver.findElement(By.cssSelector(".success-msg")).getText();

        List<WebElement> wishlistProductTitleList = driver.findElements(By.cssSelector("#wishlist-table tbody .product-name a"));

        boolean isProductTitleFoundInWishlist = false;
        for (WebElement wishlistProductTitleElement : wishlistProductTitleList) {
            if (wishlistProductTitleElement.getText().equals(productTitle)) {
                isProductTitleFoundInWishlist = true;
                break;
            }
        }
        Assert.assertEquals((productTitle + " has been added to your wishlist. Click here to continue shopping.").toLowerCase(), wishlistSuccessMsg.toLowerCase());

        Assert.assertTrue(isProductTitleFoundInWishlist);

        driver.findElement(By.cssSelector("#wishlist-table tbody tr:first-child .btn-remove")).click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void addToWishlistASpecifiedProduct() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".skip-content.skip-active li:last-child a")).click();
        driver.findElement(By.id("email")).sendKeys("bellatest@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".nav-5 > a")).click();
        driver.findElement(By.cssSelector(".category-products .item:first-child .actions .button")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_color li:first-child a")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_size li:first-child a")).click();

        String productTitle = driver.findElement(By.cssSelector(".product-view .product-name span")).getText();

        driver.findElement(By.cssSelector(".link-wishlist")).click();

        String wishlistSuccessMsg = driver.findElement(By.cssSelector(".success-msg")).getText();

        List<WebElement> wishlistProductTitleList = driver.findElements(By.cssSelector("#wishlist-table tbody .product-name a"));

        boolean isProductTitleFoundInWishlist = false;
        for (WebElement wishlistProductTitleElement : wishlistProductTitleList) {
            if (wishlistProductTitleElement.getText().equals(productTitle)) {
                isProductTitleFoundInWishlist = true;
                break;
            }
        }
        Assert.assertEquals((productTitle + " has been added to your wishlist. Click here to continue shopping.").toLowerCase(), wishlistSuccessMsg.toLowerCase());

        Assert.assertTrue(isProductTitleFoundInWishlist);

        driver.findElement(By.cssSelector("#wishlist-table tbody tr:first-child .btn-remove")).click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void addToCartANonSpecifiedProductFromWishlist() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".skip-content.skip-active li:last-child a")).click();
        driver.findElement(By.id("email")).sendKeys("bellatest@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".nav-5 > a")).click();
        driver.findElement(By.cssSelector(".category-products .item:first-child .actions .button")).click();

        String productTitle = driver.findElement(By.cssSelector(".product-view .product-name span")).getText();

        driver.findElement(By.cssSelector(".link-wishlist")).click();

        String wishlistSuccessMsg = driver.findElement(By.cssSelector(".success-msg")).getText();

        List<WebElement> wishlistProductTitleList = driver.findElements(By.cssSelector("#wishlist-table tbody .product-name a"));

        boolean isProductTitleFoundInWishlist = false;
        for (WebElement wishlistProductTitleElement : wishlistProductTitleList) {
            if (wishlistProductTitleElement.getText().equals(productTitle)) {
                isProductTitleFoundInWishlist = true;
                break;
            }
        }
        Assert.assertEquals((productTitle + " has been added to your wishlist. Click here to continue shopping.").toLowerCase(), wishlistSuccessMsg.toLowerCase());

        Assert.assertTrue(isProductTitleFoundInWishlist);

        driver.findElement(By.cssSelector(".cart-cell .btn-cart")).click();

        String specifyMsg = driver.findElement(By.cssSelector(".notice-msg")).getText();

        Assert.assertEquals("Please specify the product's option(s).", specifyMsg);

        driver.findElement(By.cssSelector("#configurable_swatch_color li:first-child a")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_size li:first-child a")).click();
        driver.findElement(By.cssSelector(".add-to-cart .button")).click();

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

        driver.findElement(By.cssSelector("#shopping-cart-table tbody tr:first-child .product-cart-remove .btn-remove")).click();

    }

    @Test
    public void addToCartASpecifiedProductFromWishlist() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".skip-content.skip-active li:last-child a")).click();
        driver.findElement(By.id("email")).sendKeys("bellatest@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".nav-5 > a")).click();
        driver.findElement(By.cssSelector(".category-products .item:first-child .actions .button")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_color li:first-child a")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_size li:first-child a")).click();

        String productTitle = driver.findElement(By.cssSelector(".product-view .product-name span")).getText();

        driver.findElement(By.cssSelector(".link-wishlist")).click();

        String wishlistSuccessMsg = driver.findElement(By.cssSelector(".success-msg")).getText();

        List<WebElement> wishlistProductTitleList = driver.findElements(By.cssSelector("#wishlist-table tbody .product-name a"));

        boolean isProductTitleFoundInWishlist = false;
        for (WebElement wishlistProductTitleElement : wishlistProductTitleList) {
            if (wishlistProductTitleElement.getText().equals(productTitle)) {
                isProductTitleFoundInWishlist = true;
                break;
            }
        }
        Assert.assertEquals((productTitle + " has been added to your wishlist. Click here to continue shopping.").toLowerCase(), wishlistSuccessMsg.toLowerCase());

        Assert.assertTrue(isProductTitleFoundInWishlist);

        driver.findElement(By.cssSelector(".cart-cell .btn-cart")).click();

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

        driver.findElement(By.cssSelector("#shopping-cart-table tbody tr:first-child .product-cart-remove .btn-remove")).click();
    }

    @Test
    public void deleteFromTheWishlist() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".skip-content.skip-active li:last-child a")).click();
        driver.findElement(By.id("email")).sendKeys("bellatest@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".nav-5 > a")).click();
        String productTitle = driver.findElement(By.cssSelector(".category-products .item:first-child .product-name a")).getText();

        driver.findElement(By.cssSelector(".category-products .item:first-child .link-wishlist")).click();

        String wishlistSuccessMsg = driver.findElement(By.cssSelector(".success-msg")).getText();

        List<WebElement> wishlistProductTitleList = driver.findElements(By.cssSelector("#wishlist-table tbody .product-name a"));

        boolean isProductTitleFoundInWishlist = false;
        for (WebElement wishlistProductTitleElement : wishlistProductTitleList) {
            if (wishlistProductTitleElement.getText().equals(productTitle)) {
                isProductTitleFoundInWishlist = true;
                break;
            }
        }
        Assert.assertEquals((productTitle + " has been added to your wishlist. Click here to continue shopping.").toLowerCase(), wishlistSuccessMsg.toLowerCase());

        Assert.assertTrue(isProductTitleFoundInWishlist);

        driver.findElement(By.cssSelector("#wishlist-table tbody tr:first-child .btn-remove")).click();
        driver.switchTo().alert().accept();

        Assert.assertTrue(driver.findElements(By.id("#wishlist-table")).isEmpty());

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}