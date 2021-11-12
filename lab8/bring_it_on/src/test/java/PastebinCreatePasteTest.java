import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastebinCreatePasteResultsPage;
import page.PastebinHomePage;

import java.util.concurrent.TimeUnit;

public class PastebinCreatePasteTest {

    private WebDriver driver;
    private static final String CODE = "git config --global user.name  \"New Sheriff in Town\"\n" +
                                       "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                       "git push origin master --force";
    private static final String NAME = "how to gain dominance among developers";
    private static final String SYNTAX = "Bash";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void createBashPaste_pageHeaderCompare_checkSyntaxHighlighting_checkCodeTest() {
        PastebinHomePage homePage = new PastebinHomePage(driver);
        PastebinCreatePasteResultsPage resultsPage = homePage
                .openHomePage()
                .pasteCode(CODE)
                .selectSyntaxHighlighting()
                .selectExpiration()
                .pasteName(NAME)
                .createPaste();
        Assert.assertEquals(NAME, resultsPage.getTitleResultText());
        Assert.assertEquals(SYNTAX, resultsPage.getSyntaxHighlightingResultText());
        Assert.assertEquals(CODE, resultsPage.getTextareaResultText());
    }



    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
