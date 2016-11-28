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

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[1]/table/tbody/tr[1]/td/div/a")
    private WebElement allUsers;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/input")
    private WebElement inputTextBoxName;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[1]/table/tbody/tr[5]/td/div/a")
    private WebElement myFriends;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[3]/table/tbody/tr[2]/td/div/button[1]")
    private WebElement sendMessToUser;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[7]/table/tbody/tr[2]/td/div/input[2]")
    private WebElement theme;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[7]/table/tbody/tr[2]/td/div/textarea")
    private WebElement message;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[7]/table/tbody/tr[2]/td/div/button")
    private WebElement sendButton;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[1]/table/tbody/tr[4]/td/div/a")
    private WebElement myMessages;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[6]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr/td[5]/button")
    private WebElement answer;

    @FindBy(xpath = "/html/body/div[3]/div/table/tbody/tr[2]/td[2]/div/div/button[2]")
    private WebElement answerToUser;

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
        driver.navigate().to("http://javarush.ru/Profile.html?v=8#profile");
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
        driver.navigate().to("http://javarush.ru/Profile.html?v=8#profile");
        utils.Sleep();
        myMessages.click();
        utils.Sleep();
        return driver.getPageSource().contains(from);
    }
    public boolean answerOnMessage(String from, String to, String secrKey){
        LoginPage loginPage = new LoginPage(driver);
        driver.navigate().to("http://javarush.ru/Profile.html?v=8#profile");
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
        driver.navigate().to("http://javarush.ru/Profile.html?v=8#profile");
        utils.Sleep();
        myMessages.click();
        utils.Sleep();
        return driver.getPageSource().contains(to);
    }
}
