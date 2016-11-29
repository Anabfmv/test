package Pages;
import org.openqa.selenium.By;
import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursePage extends AbstractPage {
    private Utils utils=new Utils();


    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/div[5]")
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

    public boolean passLesson(){
        driver.navigate().to("http://javarush.ru/Profile.html?v=8#profile");
        utils.Sleep();
        int n1=Integer.parseInt(countShip.getText().substring(1));
        driver.navigate().to("http://javarush.ru/course.html?v=8");
        utils.Sleep();
        driver.navigate().to("http://javarush.ru/api/rest/user/lessonComplete.json?sessionId=347c79bf-a326-4032-905a-26bcae07a63a");
        utils.Sleep();
        driver.navigate().to("http://javarush.ru/Profile.html?v=8#profile");
        utils.Sleep();
        return  n1>Integer.parseInt(countShip.getText().substring(1));
    }
}