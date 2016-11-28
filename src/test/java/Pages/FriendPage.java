package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.Utils;

public class FriendPage extends AbstractPage{
    private Utils utils = new Utils();

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[1]/table/tbody/tr[1]/td/div/a")
    private WebElement allUsers;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/input")
    private WebElement inputTextBoxName;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[3]/table/tbody/tr[2]/td/div/button[2]")
    private WebElement addButton;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[1]/table/tbody/tr[5]/td/div/a")
    private WebElement myFriends;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[3]/table/tbody/tr[2]/td/div/button[2]")
    private WebElement deleteButton;

    public FriendPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public boolean addFriend(String anonName){
        driver.navigate().to("http://javarush.ru/Profile.html?v=8#profile");
        utils.Sleep();
        allUsers.click();
        utils.Sleep();
        inputTextBoxName.sendKeys(anonName);
        searchButton.click();
        utils.Sleep();
        //to do
        driver.findElement(By.linkText(anonName)).click();
        utils.Sleep();
        addButton.click();
        utils.Sleep();
        myFriends.click();
        utils.Sleep();
        return driver.getPageSource().contains(anonName);
    }

    public boolean deleteFriend(String anonName){
        driver.navigate().to("http://javarush.ru/Profile.html?v=8#profile");
        utils.Sleep();
        myFriends.click();
        utils.Sleep();
        driver.findElement(By.linkText(anonName)).click();
        utils.Sleep();
        deleteButton.click();
        utils.Sleep();
        myFriends.click();
        utils.Sleep();
        driver.navigate().refresh();
        return driver.getPageSource().contains(anonName);
    }
}
