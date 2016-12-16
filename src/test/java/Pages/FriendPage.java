package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.Utils;

public class FriendPage extends AbstractPage{
    private Utils utils = new Utils();

    @FindBy(xpath = "//a[@href='#people' and text()='Все Пользователи'] ")
    private WebElement allUsers;

    @FindBy(xpath = "(//tr/td/input)[1]")
    private WebElement inputTextBoxName;

    @FindBy(xpath = "//button[text()='Поиск']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[text()='Добавить в друзья']")
    private WebElement addButton;

    @FindBy(xpath = "//a[text()='Мои Друзья']")
    private WebElement myFriends;

    @FindBy(xpath = "//button[text()='Удалить из друзей']")
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
       driver.navigate().to(URL_B);
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
        driver.navigate().to(URL_B);
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
