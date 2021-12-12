import org.openqa.selenium.WebElement;

public class Main {

    public static void main(String[] args) {
        LoginTest login = new LoginTest();
        WishListTest wishlistTest = new WishListTest();
        RegisterTest registerTest = new RegisterTest();
        DropDownTest dropDownTest = new DropDownTest();
        CartTest cartTest = new CartTest();

//        registerTest.registerWithValidDates();
//        registerTest.registerWithRegisteredEmailAddress();
//        registerTest.registerWithoutFillingARequiredField();
//        registerTest.registerWithInvalidEmailAddress();
//        registerTest.registerWithDifferentPasswords();
//        wishlistTest.addToWishListFromSale();
//        login.loginWithValidCredentials();
//        login.loginWithInvalidEmail();
//        login.loginWithInvalidPassword();
//        dropDownTest.dropdownTestSortByPosition();
//        dropDownTest.dropdownTestSortByName();
//        dropDownTest.dropdownTestSortByPrice();

//        dropDownTest.dropdownTestShow();
        cartTest.addToCartWithoutLogin();

    }
}

