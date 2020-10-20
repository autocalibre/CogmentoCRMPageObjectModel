package com.cogmento.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.cogmento.qa.util.TestUtil;
import com.cogmento.qa.util.webEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static webEventListener eventListener;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fileIn = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\cogmento\\qa\\config\\config.properties");
			prop.load(fileIn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WebDriver initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new webEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		return driver;

	}
}
