import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GoogleCloudHomePage;
import page.GoogleCloudPricingCalculatorPage;

public class GoogleCloudPricingCalculatorTest {
    private WebDriver driver;
    private final static String TERM = "Google Cloud Platform Pricing Calculator";
    private final static int NUMBER_OF_INSTANCES = 4;
    private final static String VM_CLASS = "regular";
    private final static String INSTANCE_TYPE = "n1-standard-8";
    private final static String REGION = "Frankfurt";
    private final static String LOCAL_SSD = "2x375 GiB";
    private final static String COMMITMENT_TERM = "1 Year";
    private final static String INSTANCES_COST = "1,084.69";

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1440, 900));
    }

    @Test
    void VMClass_InstanceType_Region_LocalSSD_CommitmentTerm_InstancesCost_CompareTest() {
        GoogleCloudHomePage GoogleCloudPage = new GoogleCloudHomePage(driver);

        final GoogleCloudPricingCalculatorPage calculatorPage = GoogleCloudPage.openHomePage()
                .searchTerm(TERM)
                .openCalculator()
                .pasteNumberOfInstances(NUMBER_OF_INSTANCES)
                .selectSeries()
                .selectMachineType()
                .addGPUs()
                .addSSD()
                .selectDatacenter()
                .selectCommittedUsage()
                .addToEstimate();

        final String VMClass = calculatorPage.copyVMClass();
        final String instanceType = calculatorPage.copyInstanceType();
        final String region = calculatorPage.copyRegion();
        final String localSSD = calculatorPage.copyLocalSSD();
        final String commitmentTerm = calculatorPage.copyCommitmentTerm();
        final String instancesCost = calculatorPage.copyInstancesCost();

        Assert.assertEquals(VMClass, VM_CLASS);
        Assert.assertEquals(instanceType, INSTANCE_TYPE);
        Assert.assertEquals(region, REGION);
        Assert.assertEquals(localSSD, LOCAL_SSD);
        Assert.assertEquals(commitmentTerm, COMMITMENT_TERM);
        Assert.assertEquals(instancesCost, INSTANCES_COST);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        driver = null;
    }
}