package com.Utilities.Annotation;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.lang.reflect.Field;




public class Injector {

    public static void inject(Page driver, Object instance) {

        Field[]   fields= instance.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FindByPW.class)) {
               FindByPW annotation = field.getAnnotation(FindByPW.class);
                String locatorValue = annotation.locator();
                Locator locator = driver.locator(locatorValue);

                field.setAccessible(true); // should work on private fields
                try {
                    field.set(instance, locator);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }




}

