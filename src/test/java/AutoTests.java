import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Steps.Steps;
import Utils.Utils;
public class AutoTests {
    private Utils utils;
    private Steps steps;
    private final String secrKeyAnon1 = "3acd13ab-d6c1-4e43-abb0-589bbbebe9a2";
    private final String anon1 = "Clash";
    private final String linkInvite = "http://javarush.ru/user/reference/ed2c0db7-5a3d-46f8-a09e-75f50f9faf67";
    private final String user2Name="Clashko";
    private final String secrKeyClashko="9a3afbe9-5133-4f6e-80d5-d32f718854fa";
    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        utils=new Utils();
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Login to JavaRush")//+
    public void logInJavaRush() {
        steps.logInJavaRush(secrKeyAnon1);
       utils.Sleep();
        Assert.assertTrue(steps.isLoggedIn(anon1));
    }

    @Test(description = "LogOut from JavaRush")//+
    public void logOutJavaRush(){
        steps.logInJavaRush(secrKeyAnon1);
        utils.Sleep();
        steps.logOutJavaRush();
        Assert.assertTrue(steps.isLoggedOut());
    }

    @Test(description = "invite user to JavaRush")//+
    public void inviteUser(){

        String anon2Name = steps.inviteUser(linkInvite);
     utils.Sleep();
        steps.logInJavaRush(secrKeyAnon1);
        utils.Sleep();
        Assert.assertTrue(steps.isInvited(anon2Name));
    }

    @Test(description = "add friend on JavaRush")//+
    public void addFriend(){
        steps.logInJavaRush(secrKeyAnon1);
        utils.Sleep();
        Assert.assertTrue(steps.addFriend(user2Name));
    }

    @Test(description = "delete friend on JavaRush")//+
    public void deleteFriend(){
        steps.logInJavaRush(secrKeyAnon1);
        utils.Sleep();
        Assert.assertFalse(steps.deleteFriend(user2Name));
    }
    @Test(description = "send message on JavaRush")
    public void sendMessage(){
        steps.logInJavaRush(secrKeyAnon1);
        utils.Sleep();
        Assert.assertTrue(steps.sendMessage(anon1,user2Name,secrKeyClashko));
    }
    @Test(description = "answer on message on JavaRush")
    public void answerOnMessage(){
        steps.logInJavaRush(secrKeyClashko);
        utils.Sleep();
       Assert.assertTrue(steps.answerOnMessage(anon1,user2Name,secrKeyAnon1));
    }

    @Test(description = "answer on message on JavaRush")
    public void changeNickName(){
        steps.logInJavaRush(secrKeyAnon1);
        utils.Sleep();
        String newNick=steps.changeNickName();
        Assert.assertTrue(steps.nickNameIsChanged(newNick));
    }

    @Test(description = "pass the lesson on JavaRush")//+
    public void passLesson(){
        steps.logInJavaRush(secrKeyAnon1);
        utils.Sleep();
        Assert.assertTrue(steps.passLesson());
    }

    @AfterMethod(description = "Close browser")
    public void closeBrowser() {
        steps.closeDriver();
    }
}
