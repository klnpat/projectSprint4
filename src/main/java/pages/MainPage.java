package pages;

import order.variables.OrderButtons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver driver;
    //Кнопка "Заказать" в хедере
    private final By btnOrderInTheHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Кнопка "Заказать" в середине
    private final By btnOrderInTheMiddle = By.className("Button_Middle__1CSJM");
    //Кнопка куки
    private final By btnCookie = By.className("App_CookieButton__3cvqF");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieButton() {
        driver.findElement(btnCookie).click();
    }

    public void clickOrderButtonInTheHeader() {
        driver.findElement(btnOrderInTheHeader).click();
    }

    public void clickOrderButtonInTheMiddle() {
        driver.findElement(btnOrderInTheMiddle).click();
    }

    public void clickOrderButton(String button) {
        if(button.equals(OrderButtons.HEADER_ORDER_BUTTON)){
            clickOrderButtonInTheHeader();
        }else{
            clickOrderButtonInTheMiddle();
        }
    }

    public void clickQuestion(String myQuestion) {
        WebElement question = driver.findElement(By.xpath(".//div[(@class='accordion__button') and (text() ='" + myQuestion + "')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }

    public WebElement findAnswerByQuestion(String myQuestion) {
        WebElement question = driver.findElement(By.xpath(".//div[(@class='accordion__button') and (text() ='" + myQuestion + "')]"));
        String id = question.getAttribute("id");
        return driver.findElement(By.xpath(".//div[@aria-labelledby = '" + id + "']"));
    }

}
