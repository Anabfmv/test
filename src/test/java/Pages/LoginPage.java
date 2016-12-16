package Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.Utils;
public class LoginPage extends AbstractPage{
    private Utils utils=new Utils();
    private final String nickName="Clash2";

    @FindBy (id = "pProfileLink")
    private WebElement profilePage;

    @FindBy(xpath = "//input[@id='secretKeyBox']")
    private WebElement loginTextBox;

    @FindBy(xpath = "(//button)[5]")
    private  WebElement loginButton;

    @FindBy(xpath = "//a[text()='Выход']")
    private  WebElement loginOut;

    @FindBy(xpath = "(//div[@class='gwt-Label profile-user-name'])[2]")
    private WebElement linkLoggedInUser;

    @FindBy (xpath = "//button[text()='Начать обучение']")
    private WebElement startLesson;

    @FindBy (xpath = "//a[text()='Мои Личные данные']")
    private WebElement myData;

    @FindBy (xpath = "//input[@class='gwt-TextBox profile-private-user-name profile-user-textbox-textbox']")
    private WebElement nickNameTB;

    @FindBy (xpath = "//button[text()='Сохранить']")
    private WebElement saveChanges;

     public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void logIn(String secretKey)
    {
        startLesson.click();
        loginTextBox.sendKeys(secretKey);
        loginButton.click();

    }

    public String getLoggedInUserName()
    {
        driver.navigate().to(URL_B);
        utils.Sleep();
        return linkLoggedInUser.getText();
    }

    public void logOut(){
        driver.navigate().to(URL_B);
        utils.Sleep();
        loginOut.click();
    }

    public boolean isLogOut(){
        return  startLesson.isDisplayed();
    }

    public String changeNickName(){
        driver.navigate().to(URL_B);
        utils.Sleep();
        myData.click();
        utils.Sleep();
        nickNameTB.clear();
        utils.Sleep();
        nickNameTB.sendKeys(nickName);
        saveChanges.click();
        utils.Sleep();
        return nickName;
    }
    public boolean nickNameIsChanged(String newNick){
        driver.navigate().to(URL_B);
        utils.Sleep();
        String tbNickName=linkLoggedInUser.getText();
        utils.Sleep();
        myData.click();
        utils.Sleep();
        nickNameTB.clear();
        utils.Sleep();
        nickNameTB.sendKeys("Clash");
        saveChanges.click();
        utils.Sleep();
        return tbNickName.equals(newNick);
    }
}