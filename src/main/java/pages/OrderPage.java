package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    WebDriver driver;
    //Поле "Имя"
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    //Поле "Фамилия"
    private final By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле "Адрес"
    private final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле "Метро"
    private final By selectMetro = By.className("select-search__input");
    //Поле "Телефон"
    private final By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By btnNext = By.xpath(".//button[text()='Далее']");
    //Поле "Дата"
    private final By inputDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Верхний заголовок
    private final By orderHeader = By.className("Order_Header__BZXOb");
    //Поле "Срок аренды"
    private final By dropdownPeriod = By.className("Dropdown-control");
    //Поле "Комментарий"
    private final By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    private final By btnOrder = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM') and (text()='Заказать')]");
    //Кнопка "Да" в попапе "Хотите заказать?"
    private final By btnOrderYes = By.xpath(".//button[text()='Да']");
    //Попап "Заказ оформлен"
    private final By textOrderInProcess = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void chooseMetro(String metro) {
        driver.findElement(selectMetro).sendKeys(metro);
        driver.findElement(By.xpath(".//div[text()='" + metro + "']")).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(inputPhone).sendKeys(phoneNumber);
    }

    public void clickNextButton() {
        WebElement nextButton = driver.findElement(btnNext);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", nextButton);
        nextButton.click();
    }

    public void inputDate(String date) {
        driver.findElement(inputDate).sendKeys(date);

    }

    public void clickSomewhere() {
        driver.findElement(orderHeader).click();
    }

    public void setDate(String date) {
        inputDate(date);
        clickSomewhere();
    }

    public void clickOnPeriod() {
        driver.findElement(dropdownPeriod).click();
    }

    public void choosePeriod(String period) {
        driver.findElement(By.xpath(".//div[(@class='Dropdown-option') and (text()='" + period + "')]")).click();
    }

    public void setPeriod(String period) {
        clickOnPeriod();
        choosePeriod(period);
    }

    public void chooseColour(String colour) {
        driver.findElement(By.xpath(".//label[(@class='Checkbox_Label__3wxSf') and (@for='" + colour + "')]")).click();
    }

    public void setComment(String comment) {
        driver.findElement(inputComment).sendKeys(comment);
    }

    public void clickFinishOrderButton() {
        driver.findElement(btnOrder).click();
    }

    public void clickYesButton() {
        driver.findElement(btnOrderYes).click();
    }

    public String getTextFromPopup() {
        return driver.findElement(textOrderInProcess).getText();
    }
}
