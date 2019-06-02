package com.cleartrip.qa.pages;

import com.cleartrip.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends TestBase {
    @FindBy(id = "userAccountLink")
    WebElement yourTripLink;

    @FindBy(id = "SignIn")
    WebElement signInLink;

    @FindBy(id = "signInButton")
    WebElement signInButton;

    @FindBy(id = "modal_window")
    WebElement frameId;

    @FindBy(xpath = "//div[@id='errors1']/span")
    WebElement userName;

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    public String AnErrorIfSignInDetailsAreMissing()
    {
        String errorMessage = "";
        yourTripLink.click();
        signInLink.click();
        driver.switchTo().frame(frameId);
        signInButton.click();
        errorMessage = userName.getText();
        driver.switchTo().defaultContent();
        return errorMessage;
    }
}
