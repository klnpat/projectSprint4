import config.AppConfig;
import config.WebDriverConfig;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;


@RunWith(Parameterized.class)
public class ClickQuestionGetAnswerTest {
    private WebDriver driver;
    private final String question;
    private final String answer;

    public ClickQuestionGetAnswerTest(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    @Parameterized.Parameters
    public static Object[] getAnswer() {
        return new Object[][] {
                { "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                { "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WebDriverConfig.WAIT_SEC_TIMEOUT, TimeUnit.SECONDS);

        driver.navigate().to(AppConfig.MAIN_PAGE_URL);

    }
    @Test
    public void checkClickQuestionGetAnswer() {
        MainPage page = new MainPage(driver);
        page.clickQuestion(question);
        Assert.assertEquals(answer, page.findAnswerByQuestion(question).getText());

    }
    @After
    public void teardown() {
        driver.quit();
    }
}
