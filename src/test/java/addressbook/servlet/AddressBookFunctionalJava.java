package addressbook.servlet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AddressBookFunctionalJava {
  private WebDriver phantomDriver;
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  protected static DesiredCapabilities dCaps;

  @Before
  public void setUp() throws Exception {
	  
	dCaps = new DesiredCapabilities();
	dCaps.setJavascriptEnabled(Boolean.TRUE);
	dCaps.setCapability("takesScreenshot", Boolean.FALSE);
	
	driver = new PhantomJSDriver( dCaps );
   // driver = new FirefoxDriver();
    baseUrl = "http://addressbook.joyedele.cloudbees.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddressBookTestCase() throws Exception {
    driver.get(baseUrl + "/");
    assertEquals("Test Address book", driver.getTitle());
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Address Book[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Entry Phone[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys("John Oyedele");
    driver.findElement(By.name("phoneNumber")).clear();
    driver.findElement(By.name("phoneNumber")).sendKeys("2145570889");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
