package com.automationexercise.base;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.nio.file.Paths;

public class BaseAction {
    protected static Page page;

    public BaseAction(Page page)
    {
        this.page = page;
    }

    public static void click(String selector) {

        Locator element = page.locator(selector);

        element.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        element.click();

        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    // Enter Text
    public static void type(String selector, String text) {

        Locator element = page.locator(selector);

        element.waitFor();

        element.fill(text);
    }

    // Select Dropdown
    public static void selectByValue(String selector, String value) {

        Locator dropdown = page.locator(selector);

        dropdown.waitFor();

        dropdown.selectOption(value);
    }

    // File Upload
    public static void uploadFile(String selector, String path) {

        Locator upload = page.locator(selector);

        upload.waitFor();

        upload.setInputFiles(Paths.get(path));
    }

    public void scrollAndClick(String selector) {

        Locator element = page.locator(selector);

        element.scrollIntoViewIfNeeded();

        element.click();
    }
}


