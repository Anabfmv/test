package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.Utils;
public class InvitePage extends AbstractPage{
    private Utils utils=new Utils();
    @FindBy(xpath = "/html/body/header/div[1]/div/div[2]/button")
    private WebElement startLessons;

    @FindBy(xpath = "//*[@id=\"rightmenu1\"]/form[4]/div/button/div")
    private WebElement generateSecret;

    @FindBy(xpath = "//*[@id=\"secretKeyForm\"]/div/button/div")
    private WebElement logIn;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/div[2]")
    private WebElement userName;

    @FindBy(xpath = "//*[@id=\"menu-item-exit\"]/a")
    private WebElement logOut;

    @FindBy(xpath = "//*[@id=\"center\"]/table/tbody/tr/td[1]/table/tbody/tr[6]/td/div/a")
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
        driver.navigate().to("http://javarush.ru/Profile.html?v=8#profile");
        utils.Sleep();
        String anonName=userName.getText();
        logOut.click();
        return anonName;
    }

    public boolean isInvited(String anonName){
        driver.navigate().to("http://javarush.ru/Profile.html?v=8#profile");
        myInvites.click();
        utils.Sleep();
        return driver.getPageSource().contains(anonName);
    }
}
