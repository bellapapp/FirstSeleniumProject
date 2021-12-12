import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {

    public void addToCartWithoutLogin() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.id("product-collection-image-403")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li > div > div.actions > a")).click();
        // de aici mai departe nu am reusit deocamdata:(
    }
}
