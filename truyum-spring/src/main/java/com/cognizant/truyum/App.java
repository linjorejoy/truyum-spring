package com.cognizant.truyum;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println(context);
        
        MenuItemDaoCollectionImpl impl = (MenuItemDaoCollectionImpl) context.getBean("menuItemDaoCollectionImpl");

        
        for(MenuItem item : impl.getMenuItemListAdmin()) {
            System.out.println(item);
        }
        
        MenuItemService service = context.getBean(MenuItemService.class);
        
        System.out.println("**************************");
        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext();
        context2.scan("com.cognizant");
        context2.refresh();
        
        MenuItemService service2 = context2.getBean(MenuItemService.class);
        for(MenuItem item : service2.getMenuItemListAdmin()) {
            System.out.println(item);
        }

    }
}
