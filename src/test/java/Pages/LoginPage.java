package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.Utils;
public class LoginPage extends AbstractPage{
    private Utils utils=new Utils();
    private final String nickName="Clash2";

    @FindBy (id = "pProfileLink")
    private WebElement profilePage;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div[1]/form[5]/input")
    private WebElement loginTextBox;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div[1]/form[5]/div/button")
    private  WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"menu-item-exit\"]/a")
    private  WebElement loginOut;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/div[2]")
    private WebElement linkLoggedInUser;

    @FindBy (xpath = "/html/body/header/div[1]/div/div[2]/button")
    private WebElement startLesson;

    @FindBy (xpath = "//*[@id=\"center\"]/table/tbody/tr/td[1]/table/tbody/tr[3]/td/div/a")
    private WebElement myData;

    @FindBy (xpath = "//*[@id=\"center\"]/table/tbody/tr/td[5]/table/tbody/tr/td/div/input[1]")
    private WebElement nickNameTB;

    @FindBy (xpath = "//*[@id=\"center\"]/table/tbody/tr/td[5]/table/tbody/tr/td/div/button")
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
        driver.navigate().to("http://javarush.ru/Profile.html?v=8#profile");
        utils.Sleep();
        return linkLoggedInUser.getText();
    }

    public void logOut(){
        driver.navigate().to("http://javarush.ru/Profile.html?v=8#profile");
        utils.Sleep();
        loginOut.click();
    }

    public boolean isLogOut(){
        return  startLesson.isDisplayed();
    }

    public String changeNickName(){
        driver.navigate().to("http://javarush.ru/Profile.html?v=8#profile");
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
        driver.navigate().to("http://javarush.ru/Profile.html?v=8#profile");
        utils.Sleep();
        String tbNickName=linkLoggedInUser.getText();
        utils.Sleep();
        //change nickname to previous state
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