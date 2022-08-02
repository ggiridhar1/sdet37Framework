package com.crm.genericUtilitity;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author 91900
 *
 */
public class webdriverUtility {
	/**
	 * This method is used  maximize the browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to minimize the browser
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to refresh the browser
	 * @param driver
	 */
	public void refreshTheBrowser(WebDriver driver) {
		driver.navigate().refresh();
	}
	/**
	 * This method is to get backward to previous page
	 * @param driver
	 */
	public void backTOPreviousBrowser(WebDriver driver) {
		driver.navigate().back();
	}
	/**
	 * This method is to move Forward to nextpage 
	 * @param driver
	 */
	public void forwardTOBrowser(WebDriver driver) {
		driver.navigate().forward();
	}
	/**
	 * This method is to wait until page gets loaded
	 * @param driver
	 */
	public void waitUntilPageGetsLoaded(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Iconstants.implicitlyWaitDuration));
	}
	/**
	 * This method will wait till element to click
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToCLick(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Iconstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Iconstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for title of the page 
	 * @param driver
	 * @param title
	 */
	public void waitTillPageLoadTitle(WebDriver driver,String title) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Iconstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 *This method will wait for the URL of the page 
	 * @param driver
	 * @param URL
	 */
	public void waitTillPageLoadURL(WebDriver driver,String URL) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Iconstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.urlContains(URL));
	}
	/**
	 * This method will ignore the no such element exec
	 * @param driver
	 */
	public void ignoreNoSuchElementException(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Iconstants.explicitlyWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * This method will wait till the alert msg to be visible
	 * @param driver
	 */
	public void waitforAlertMsg(WebDriver driver) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(Iconstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * This method is used to switch to frame using id
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch to frame using id
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver,String id) {
		driver.switchTo().frame(id);
	}
	/**
	 * This method is used to switch to frame using element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);	
	}
	/**
	 * This method is used to switch to main frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to get the elements in a dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index ) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method is used to get the elements in a dropdown using index
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This method is used to get elements from dropdowns using visible text
	 * @param value
	 * @param element
	 */
	public void select(String value, WebElement element) {
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}
	/**
	 * This method is used to get all the elements from the dropdown
	 * @param element
	 */
	public void getAlltheoptionsFromDropDown(WebElement element) {
		Select select=new Select(element);
		List<WebElement> option = select.getOptions();
		for (WebElement webElement : option) {
			String text =webElement.getText();
			System.out.println(text);
		}
	}
	/**
	 * This method is used to mousehoveronelement
	 * @param driver
	 * @param element
	 */
	public void mouseOveronElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method is used to right clickon the element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
	}
	/**
	 * This method is used to double click on the webElement
	 * @param driver
	 * @param element
	 */
	public void Doubleclick(WebDriver driver, WebElement element) {
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	/**
	 * This method is used to click on enter button
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver) {
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
	}
	public void takeScreenShot(WebDriver driver, String screenshotname) {
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File dstFile=new File("./screenShots/"+screenshotname+".PNG");
		try {
			FileUtils.copyFile(src, dstFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void waitUntilClickUsingCustomwait(WebDriver driver) {
		FluentWait fluentWait =new FluentWait(driver);
		fluentWait.ignoring(NoSuchElementException.class);
	}
	/**
	 * This method will wait till webelement is clickable
	 * @param element
	 * @param duration
	 * @param pollingTIme
	 */
	public void waitandCLick(WebElement element,int duration,long pollingTIme ) {
		int count =0;
		while (count<duration) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(pollingTIme);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				count++;
			}
		}
	}
	/**
	 * This method is used switch controls to different window
	 * @param driver
	 * @param actualTitle
	 */
	public void SwitchToWindow(WebDriver driver,String actualTitle) {
		Set<String> set = driver.getWindowHandles();
		for (String string : set) {
			driver.switchTo().window(string);
			String title = driver.getTitle();
			if(title.contains(actualTitle));
			{
				break;
			}
		}
	}
	/**
	 * This method is used to switch window using iterator
	 * @param actualurl
	 * @param driver
	 */
	public void switchToWindow(String actualurl,WebDriver driver) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String wid=it.next();
			driver.switchTo().window(wid);
			String url = driver.getCurrentUrl();
			if (url.contains(actualurl)) {
				break;
			}
		}
	}
	/**
	 * This method is used to Handle popups and accept it
	 * @param driver
	 * @param expectedMsg
	 */
	public void switchToAlertPopupAndAcceptIt(WebDriver driver, String expectedMsg) {
		Alert alert = driver.switchTo().alert();
		if (alert.getText().trim().equalsIgnoreCase(expectedMsg.trim())) {
			System.out.println("ALERT MESSSAGE IS VERIFIED");
		} 
		else {
			System.out.println("ALERT MESSAGE IS NOT VERIFIED");
		}
		alert.accept();
	}
	/**
	 * This method is used to switch to alert popups and dismiss it
	 * @param expectedMsgString
	 * @param driver
	 */
	public void switchToAlertPopupAndAcceptIt(String expectedMsgString, WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		if (alert.getText().trim().contains(expectedMsgString)) {
			System.out.println("ALERT MESSAGE IS VERIFIED");
		}
		else {
			System.out.println("ALERT MESSGAE IS NOT VERIFIED");
		}
		alert.dismiss();
	}

}
