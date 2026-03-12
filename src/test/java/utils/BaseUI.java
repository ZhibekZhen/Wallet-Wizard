package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BaseUI {
    public WebDriverWait explicitWait(int seconds) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
    }

    public void waitAndClick(WebElement element) {
        waitUntilClickable(20, element);
        element.click();
    }

    public void waitAndSendKeys(WebElement element, String keys){
        waitUntilVisible(20, element);
        element.sendKeys(keys);
    }

    public void clearAndSendKeys(WebElement element, String keys) {
        waitUntilVisible(20, element);
        element.clear();
        element.sendKeys(keys);
    }

    public void jsClick(WebElement element) {
        explicitWait(20).until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public void jsClearAndSendKeys(WebElement element, String value) {
        explicitWait(20).until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value=''", element);
        js.executeScript("arguments[0].value=arguments[1];", element, value);
    }

    public void waitUntilClickable(int seconds, WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilVisible(int seconds, WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void selectRandomOptionFromDropdown(WebElement dropdown, By optionsLocator) {
        waitAndClick(dropdown);
        explicitWait(50).until(ExpectedConditions.numberOfElementsToBeMoreThan(optionsLocator, 1));
        int randomIndex = new Random().nextInt(0, Driver.getDriver().findElements(optionsLocator).size());
        waitAndClick(Driver.getDriver().findElements(optionsLocator).get(randomIndex));
    }

    public void sendRandomKeyAndSelectFromDropdown(WebElement dropdownInput, By optionsLocator) {
        waitUntilVisible(20, dropdownInput);
        dropdownInput.sendKeys(String.valueOf((char) ('a' + new Random().nextInt(26))));
        explicitWait(50).until(ExpectedConditions.numberOfElementsToBeMoreThan(optionsLocator, 1));
        int randomIndex = new Random().nextInt(0, Driver.getDriver().findElements(optionsLocator).size());
        waitAndClick(Driver.getDriver().findElements(optionsLocator).get(randomIndex));
    }

    public void switchToNewTab(WebElement element) {
        String mainWindow = Driver.getDriver().getWindowHandle();

        element.click();

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                Driver.getDriver().switchTo().window(windowHandle);
            }
        }
        System.out.println("Currently, the driver is on: " + Driver.getDriver().getCurrentUrl());
    }

    public static boolean safeJSClick(WebElement element, int maxRetries) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        for (int i = 1; i <= maxRetries; i++) {
            try {
                js.executeScript("arguments[0].click();", element);
                System.out.println("Successfully clicked element on attempt #" + i);
                return true;
            } catch (Exception e) {
                System.err.println("Attempt #" + i + " failed to click element: " + e.getMessage());
            }
        }

        System.err.println("Failed to click element after " + maxRetries + " attempts.");
        return false;
    }


    //find whole column of a data

    public List<WebElement> getCellsListByHeader(String headerName) {
        explicitWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table thead")));

        List<WebElement> headers = Driver.getDriver().findElements(By.cssSelector("table thead th"));

        int index = -1;
        int count = 1;

        for (WebElement th : headers) {
            String text = th.getText().trim();
            if (text.contains(headerName)) {
                index = count;
                break;
            }
            count++;
        }

        if (index == -1) {
            System.out.println(headerName + " column NOT found");
        }

        explicitWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr")));

        return Driver.getDriver().findElements(By.xpath("//table/thead/tr/td[" + index + "]"));
    }

    public void printCellsFromListByHeader(String headname) {
        List<WebElement> cells = getCellsListByHeader(headname);

        for (WebElement cell : cells) {
            System.out.println(cell.getText());
        }
    }


    public List<WebElement> getCellsListByHeaderAndByLocator(By locator, String headerName) {
        WebElement table = Driver.getDriver().findElement(locator);

        explicitWait(10).until(
                ExpectedConditions.visibilityOf(table)
        );

        List<WebElement> headers = table.findElements(By.xpath(".//th"));

        int index = -1;
        int count = 1;

        for (WebElement th : headers) {
            String text = th.getText().trim();

            if (text.contains(headerName)) {
                index = count;
                break;
            }
            count++;
        }

        if (index == -1) {
            throw new RuntimeException(headerName + " column NOT found");
        }

        return table.findElements(By.xpath(".//tbody/tr/td[" + index + "]"));
    }

    public void printCellsFromListByHeaderAndByLocator(By locator,String headName) {
        List<WebElement> cells = getCellsListByHeaderAndByLocator(locator,headName);

        for (WebElement cell : cells) {
            System.out.println(cell.getText());
        }
    }


}
