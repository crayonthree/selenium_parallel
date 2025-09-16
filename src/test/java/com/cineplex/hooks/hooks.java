package com.cineplex.hooks;

import com.cineplex.utils.DriverUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks{

    @Before
    public void setUp() {
        // Create a driver instance for this scenario/thread
        DriverUtilities.getInstance().createDriver();
    }

    @After
    public void tearDown() {
        // Quit driver safely and clean up thread-local instance
        DriverUtilities.getInstance().quitDriver();
    }
}
