package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Pages.LoginPage;

import Utils.Utils;

public class MessagePage extends AbstractPage{
    private Utils utils = new Utils();

    @FindBy(xpath = "//a[text()='Все Пользователи']")
    private WebElement allUsers;

    @FindBy(xpath = "(//tr/td/input)[1]")
    private WebElement inputTextBoxName;

    @FindBy(xpath = "//button[text()='Поиск']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[text()='Мои Друзья']")
    private WebElement myFriends;

    @FindBy(xpath = "//button[text()='Написать сообщение']")
    private WebElement sendMessToUser;

    @FindBy(xpath = "//input[@style='width: 500px; height: 25px; position: absolute; left: 170px; top: 81px;']")
    private WebElement theme;

    @FindBy(xpath = "//textarea[@style='width: 570px; height: 250px; position: absolute; left: 100px; top: 150px;']")
    private WebElement message;

    @FindBy(xpath = "//button[text()='Отправить']")
    private WebElement sendButton;

    @FindBy(xpath = "//a[@href='#messages']")
    private WebElement myMessages;

    @FindBy(xpath = "//button[text()='Читать']")
    private WebElement answer;

    @FindBy(xpath = "//button[text()='Ответить']")
    private WebElement answerToUser;

    @FindBy(xpath = "//a[@id='pProfileLink']")
    private WebElement myPage;


    public MessagePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public boolean sendMessage(String from, String to, String secrKey){
        LoginPage loginPage = new LoginPage(driver);
        driver.navigate().to(URL_B);
        utils.Sleep();
        allUsers.click();
        utils.Sleep();
        inputTextBoxName.sendKeys(to);
        searchButton.click();
        utils.Sleep();
        driver.findElement(By.linkText(to)).click();
        utils.Sleep();
        sendMessToUser.click();
        utils.Sleep();
        theme.sendKeys("Hello");
        message.sendKeys("Hello my dear friend");
        sendButton.click();
        utils.Sleep();
        loginPage.logOut();
        utils.Sleep();
        loginPage.logIn(secrKey);
        utils.Sleep();
        driver.navigate().to(URL_B);
        utils.Sleep();
        myMessages.click();
        utils.Sleep();
        return driver.getPageSource().contains(from);
    }
    public boolean answerOnMessage(String from, String to, String secrKey){
        LoginPage loginPage = new LoginPage(driver);
        driver.navigate().to(URL_B);
        utils.Sleep();
        myMessages.click();
        utils.Sleep();
        answer.click();
        answerToUser.click();
        theme.sendKeys("Hello");
        message.sendKeys("Hello my dear friend");
        sendButton.click();
        utils.Sleep();
        loginPage.logOut();
        utils.Sleep();
        loginPage.logIn(secrKey);
        utils.Sleep();
        driver.navigate().to(URL_B);
        utils.Sleep();
        myMessages.click();
        utils.Sleep();
        return driver.getPageSource().contains(to);
    }
}
