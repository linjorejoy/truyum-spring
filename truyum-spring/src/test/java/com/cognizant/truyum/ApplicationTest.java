package com.cognizant.truyum;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cognizant.truyum.service.CartServiceTest;
import com.cognizant.truyum.service.MenuItemServiceTest;

@RunWith(Suite.class)
@SuiteClasses({CartServiceTest.class, MenuItemServiceTest.class})
/**
 * Test Suite to run all the Tests
 * from 
 * {@link com.cognizant.truyum.service.CartServiceTest} and 
 * {@link com.cognizant.truyum.service.MenuItemServiceTest}
 * 
 * @author LINJO
 *
 */
public class ApplicationTest {
    
}
