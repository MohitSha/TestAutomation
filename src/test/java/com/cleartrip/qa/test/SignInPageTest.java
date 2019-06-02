package com.cleartrip.qa.test;

import com.cleartrip.qa.base.TestBase;
import com.cleartrip.qa.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SignInPageTest extends TestBase {
    SignInPage signInPage;

    public SignInPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initializer();
        signInPage = new SignInPage();
    }

    @Test
    public void testErrorIfSignInDetailsAreMissing() {
        String errorMessage = "There were errors in your submission";
        Assert.assertEquals(errorMessage, signInPage.AnErrorIfSignInDetailsAreMissing());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
