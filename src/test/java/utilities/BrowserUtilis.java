package utilities;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtilis {
	final Logger logger = Logger.getLogger(BrowserUtilis.class);
	WebDriverWait letswait;

	public void waitUntilElemetIsVisible(WebElement element) {
		letswait = new WebDriverWait(Driver.getDriver(), 10);
		letswait.until(ExpectedConditions.visibilityOf(element));

	}

	public void selectDropDownText(WebElement element, String optionValue) {
		try {
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(optionValue);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}

	public void selectDropDownValue(WebElement element, String optionValue) {
		try {
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(optionValue);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}

	public void customWait(double inSeconds) {
		try {
			Thread.sleep((long) (inSeconds * 1000));
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}

	public void handleCheckBox(WebElement element, boolean isCheck) {
		try {
			boolean checkboxStatus = element.isSelected();
			if (isCheck == true) {
				if (checkboxStatus == false) {
					// scenario 1: ---> click the check-box
					element.click();
					customWait(0.5);
				} else {
					// scenario 2: ---> do nothing
				}
			} else {
				if (checkboxStatus == false) {
					// scenario 3: ---> do nothing
				} else {
					// scenario 4: ---> click the check-box to un-check
					element.click();
					customWait(0.5);
				}
			}
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}

}
