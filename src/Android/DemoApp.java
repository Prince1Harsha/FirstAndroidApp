package Android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities; //Used to set device properties:device name, platform, version, app package name, activity name, etc. It has various methods eg. setCapability()-> used to set the device name, platform version, platform name, absolute path of the app under test (the .apk file of the app(Android) under test), app Activity (in Android) and appPackage(java).
import org.testng.annotations.AfterTest; //@AfterTest annotated method will be executed when all @Test annotated methods completed its execution
import org.testng.annotations.BeforeTest; //@Before Test annotated method will be executed before any @Test method
import org.testng.annotations.Test; //@Test annotation describes method as a test method or part of your test

public class DemoApp{
AndroidDriver driver;
@BeforeTest
public void SplashScreen() throws MalformedURLException, InterruptedException {
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("deviceName", "PrinceHarsha"); //obtained from the command "adb devices"
capabilities.setCapability("browserName", "Android");
capabilities.setCapability(CapabilityType.VERSION, "6.0.1");
capabilities.setCapability("platformName", "Android");
capabilities.setCapability("appPackage", "<App package name>");
capabilities.setCapability("appActivity", "<App activity name>");
driver = new AndroidDriver(new URL("http://127.0.0.1/wd/hub"), capabilities);
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}

@Test
public void Login(){
//driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'mas_account_verification_country')]")).click(); //Open drop down country menu
driver.findElement(By.name("WhatsApp")).click(); //Select one country
//driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id, 'et_account_verification_phone_number')]")).sendKeys("9999999999"); //Enter Mobile No
/*driver.hideKeyboard(); //Hide keyboard
driver.findElement(By.name("Enter your name")).sendKeys("Parul"); //Enter name
driver.hideKeyboard(); //Hide keyboard
driver.findElement(By.className("android.widget.Button")).click(); //Click on submit button
driver.findElement(By.className("android.widget.EditText")).sendKeys("123456"); //Enter password in next screen
driver.hideKeyboard(); //Hide Keyboard, since keyboard hides the Submit button in this case
driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click(); //Click on submit button
*/
}

@AfterTest
public void end()
{
driver.quit(); //Close application
}
}