import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownTest {

    public void dropdownTestSortByPosition() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/women/tops-blouses.html");

        WebElement sorting = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > select"));

        Select dropdown = new Select(sorting);
        dropdown.selectByVisibleText("Position");
//        driver.quit();
    }

    public void dropdownTestSortByName() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/women/tops-blouses.html");

        WebElement sorting = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > select"));

        Select dropdown = new Select(sorting);
        dropdown.selectByVisibleText("Name");
//        driver.quit();
    }

    public void dropdownTestSortByPrice() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/women/tops-blouses.html");

        WebElement sorting = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > select"));

        Select dropdown = new Select(sorting);
        dropdown.selectByVisibleText("Price");
//        driver.quit();
    }

    public void dropdownTestShow12() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/women/tops-blouses.html");

        WebElement sorting = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.pager > div > div > select"));

        Select dropdown = new Select(sorting);
        dropdown.selectByVisibleText("12");
//        driver.quit();
    }

    public void dropdownTestShow24() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/women/tops-blouses.html");

        WebElement sorting = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.pager > div > div > select"));

        Select dropdown = new Select(sorting);
        dropdown.selectByVisibleText("24");
//        driver.quit();
    }

    public void dropdownTestShow36() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/women/tops-blouses.html");

        WebElement sorting = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.pager > div > div > select"));

        Select dropdown = new Select(sorting);
        dropdown.selectByVisibleText("36");
//        driver.quit();
    }


}
