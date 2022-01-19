package testMap;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class TestMap {

	public WindowsDriver MapSession = null;
	public DesiredCapabilities capabilities;

	@BeforeClass
	public void setup() {
		try {
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "Microsoft.WindowsMaps_8wekyb3d8bbwe!App");
			capabilities.setCapability("platformName", "Windows");
			capabilities.setCapability("platformVersion", "1.0");

			MapSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
			MapSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	@Test
	public void Clear() throws InterruptedException {
		MapSession.findElementByAccessibilityId("TextBox").sendKeys("Egypt");
		MapSession.findElementByAccessibilityId("TextBox").sendKeys(Keys.ENTER);
		Thread.sleep(20000);

	}

	@AfterClass
	public void TearDown() {
		if (MapSession != null) {
			MapSession.quit();
		}
		MapSession = null;
	}

}
