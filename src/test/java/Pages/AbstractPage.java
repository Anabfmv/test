package Pages;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    public abstract void openPage(String URL);
    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }
}