package org.OrangeHRMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHRMLogin {
    private static WebElement element = null;
    public static WebElement userName(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@name='username']"));
        return element;
    }
    public static WebElement Password(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@name='password']"));
        return element;
    }
    public static WebElement Loginbtn(WebDriver driver){
        element = driver.findElement(By.xpath("//button[@type='submit']"));
        return element;
    }
    public static WebElement InvalidCredentials(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']"));
        return element;
    }
}
