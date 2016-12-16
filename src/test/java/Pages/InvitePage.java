package Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.Utils;
public class InvitePage extends AbstractPage{
    private Utils utils=new Utils();
    @FindBy(xpath = "//button[text()='Начать обучение']")
    private WebElement startLessons;

    @FindBy(xpath = "//div[text()='Получить секретный ключ']")
    private WebElement generateSecret;

    @FindBy(xpath = "//div[text()='Войти по секретному ключу']")
    private WebElement logIn;

    @FindBy(xpath = "(//div[@class='gwt-Label profile-user-name'])[2]")
    private WebElement userName;

    @FindBy(xpath = "//a[text()='Выход']")
    private WebElement logOut;

    @FindBy(xpath = "//a[text()='Мои Приглашенные']")
    private WebElement myInvites;

    public InvitePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public String inviteUser()
    {
        utils.Sleep();
        startLessons.click();
        generateSecret.click();
        utils.Sleep();
        logIn.click();
        utils.Sleep();
        driver.navigate().to(URL_B);
        utils.Sleep();
        String anonName=userName.getText();
        logOut.click();
        return anonName;
    }

    public boolean isInvited(String anonName){
       driver.navigate().to(URL_B);
       myInvites.click();
       return driver.getPageSource().contains(anonName);
    }
}
