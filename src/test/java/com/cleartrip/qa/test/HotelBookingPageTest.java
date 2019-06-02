package com.cleartrip.qa.test;

import com.cleartrip.qa.base.TestBase;
import com.cleartrip.qa.pages.HotelBookingPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotelBookingPageTest extends TestBase {
    HotelBookingPage hotelBookingPage;

    public HotelBookingPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initializer();
        hotelBookingPage = new HotelBookingPage();
    }

    @Test
    public void testSearchIsWorking() throws InterruptedException {
        Assert.assertFalse(hotelBookingPage.searchForHotels() == 0);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

