package com.cognizant.truyum;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cognizant.truyum.service.CartServiceTest;
import com.cognizant.truyum.service.CartServiceTestWithXmlConfig;
import com.cognizant.truyum.service.MenuItemServiceTest;
import com.cognizant.truyum.service.MenuItemServiceTestWithXmlConfig;

@RunWith(Suite.class)
@SuiteClasses({ CartServiceTest.class, MenuItemServiceTest.class, MenuItemServiceTestWithXmlConfig.class,
        CartServiceTestWithXmlConfig.class })
/**
 * Test Suite to run all the Tests from 
 * {@link CartServiceTest} and
 * {@link MenuItemServiceTest} and
 * {@link MenuItemServiceTestWithXmlConfig} and
 * {@link CartServiceTestWithXmlConfig}
 * 
 * @author LINJO
 *
 */
public class ApplicationTest {

}
