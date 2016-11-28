package Steps;
import java.util.concurrent.TimeUnit;
import Pages.*;
import bsh.Console;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Steps {
    private WebDriver driver;

    public void initBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
    }
    public void closeDriver()
    {
        driver.close();
    }

    public void logInJavaRush(String secretKey)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage("http://javarush.ru/");
        loginPage.logIn(secretKey);
    }

    public boolean isLoggedIn(String username)
    {
        LoginPage loginPage = new LoginPage(driver);
        String name=loginPage.getLoggedInUserName();
        return (name.equals(username));
    }

    public void logOutJavaRush(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logOut();
    }
    public boolean isLoggedOut()
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.isLogOut());
    }
    public String inviteUser(String link){
        InvitePage invitePage = new InvitePage(driver);
        invitePage.openPage(link);
        return (invitePage.inviteUser());
    }
    public boolean isInvited(String userName){
        InvitePage invitePage=new InvitePage(driver);
        invitePage.openPage("http://javarush.ru/");
        return invitePage.isInvited(userName);
    }
    public boolean addFriend(String friend){
        FriendPage friendPage = new FriendPage(driver);
        return friendPage.addFriend(friend);
    }
    public boolean deleteFriend(String friend){
        FriendPage friendPage = new FriendPage(driver);
        return friendPage.deleteFriend(friend);
    }
    public boolean sendMessage(String from, String to, String secrKey){
        MessagePage messagePage=new MessagePage(driver);
        return messagePage.sendMessage(from,to,secrKey);
    }
    public boolean answerOnMessage(String from, String to, String secrKey){
        MessagePage messagePage=new MessagePage(driver);
        return messagePage.answerOnMessage(from,to,secrKey);
    }
    public String changeNickName(){
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.changeNickName();
    }
    public boolean nickNameIsChanged(String newNick){
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.nickNameIsChanged(newNick);
    }
}
