package Pages;
import org.openqa.selenium.By;
import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursePage extends AbstractPage {
    public static final String URL_K = "http://javarush.ru/course.html?v=8";
    public static final String URL_M = "http://javarush.ru/api/rest/user/lessonComplete.json?sessionId=347c79bf-a326-4032-905a-26bcae07a63a";
    private Utils utils=new Utils();


    @FindBy(xpath = "(//div[@class='gwt-Label public-user-money'])[3]")
    private WebElement countShip;

    public CoursePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }
// не удалось изменить код для ожидания загрузки страницы(он не хочет работать и все), поэтому оставила Sleep.Все остальное поменяла
    public boolean passLesson(){
        driver.navigate().to(URL_B);
        int n1=Integer.parseInt(countShip.getText().substring(1));
        utils.Sleep();
        driver.navigate().to(URL_K);
        utils.Sleep();
        driver.navigate().to(URL_M);
        utils.Sleep();
        driver.navigate().to(URL_B);
        utils.Sleep();
        return  n1>Integer.parseInt(countShip.getText().substring(1));
    }
}