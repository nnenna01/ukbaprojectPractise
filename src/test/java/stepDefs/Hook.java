package stepDefs;
import base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;


public class Hook extends BaseUtil {
    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initialize(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities dp = new DesiredCapabilities();
        dp.setCapability(ChromeOptions.CAPABILITY,options);
        options.merge(dp);
        base.driver=new ChromeDriver(options);
//        WebDriverManager.firefoxdriver().setup();
//        base.driver = new FirefoxDriver();
    }

    @After
    public void TearDown() throws IOException {
        takeScreenShot();
        base.driver.close();
        base.driver.quit();
    }

    private void takeScreenShot() throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) base.driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File("target/screenshot" + System.currentTimeMillis() + ".png"));


    }
}
