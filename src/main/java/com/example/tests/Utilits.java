package com.example.tests;

import org.apache.bcel.ExceptionConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class Utilits {


        public static void login(WebDriver driver, String email, String password) throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, 20L);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a[href=\"/HospitalSeeker/login\""))));
            driver.findElement(By.cssSelector("img.localization-flag")).click();
            driver.findElement(By.linkText("Українська")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Ввійти")));
            Thread.sleep(3000);
            driver.findElement(By.linkText("Ввійти")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("email"))));
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("loginSubmit")).click();
        }

        public static void logoutManager(WebDriver driver) throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, 30L);
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[5]/a")).click();
            driver.findElement(By.xpath("//*[@id=\"dropdawn\"]/li[2]/a/span")).click();
        }
        public static void logoutDoctor(WebDriver driver) throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, 30L);

            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[6]/a")).click();
            driver.findElement(By.xpath("//*[@id=\"dropdawn\"]/li[2]/a/span")).click();
        }

        public static void choseDoctor(WebDriver driver) {
            WebDriverWait wait = new WebDriverWait(driver, 30L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.person > img.img-responsive")));
            driver.findElement(By.cssSelector("div.person > img.img-responsive")).click();
        }

        public static void choseDayTab(WebDriver driver) {
            WebDriverWait wait = new WebDriverWait(driver, 30L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dhx_cal_tab_first")));
            driver.findElement(By.cssSelector("div.dhx_cal_tab_first")).click();
        }

        public static void choseNextWeek(WebDriver driver) {
            WebDriverWait wait = new WebDriverWait(driver, 30L);
           // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dhx_cal_next_button")));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/section/div/div/div/div/div/div[1]/div[2]")));
           // System.out.println(driver.findElements(By.cssSelector("div.dhx_cal_next_button")).size());
            driver.findElement(By.xpath("html/body/section/div/div/div/div/div/div[1]/div[2]")).click();
        }

        public static void doubleClickJS(By elem, WebDriver driver) {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            String doubleClickJS = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('dblclick',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject){ arguments[0].fireEvent('ondblclick');}window.stop();";
            js.executeScript(doubleClickJS, driver.findElement(elem));
        }
    }

