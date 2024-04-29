package org.etiya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    public static void main(String[] args) throws InterruptedException { //thread.sleep sonrasında eklendi.

        //Bir kullanıcı olarak ben adım adım nasıl yapıyorum? diye düşünerek test sürecini yönetmemiz lazım.
        //Görüntü => HTML.


        //1. Önce tarayıcıyı açıyoruz.

        WebDriver webDriver = new ChromeDriver(); // tarayıcılar arasından Chrome ile işlem yapacağım.

        // webDriver. -> tarayıcıda yapabileceğimiz işlemler çıkıyor.
        // webDriver.get() -> Belirli bir URL'e ilerler.

        webDriver.navigate().to("https://www.saucedemo.com/v1/");
        String title = webDriver.getTitle(); // Bulunduğu sekmenin title değerini alır.
        System.out.println(title);
        // webDriver.quit(); // seçtiğimiz tarayıcıda belirttiğimiz URL açılıyor, başlığı görüyorum ve sayfa kendiliğinden kapanıyor.


        //Locator: HTML'deki bir elemente ulaşmak için gerekli rota.


        //2. Kullanıcı sisteme başarılı bir şekilde girebilsin.

        WebElement usernameInput = webDriver.findElement(By.id("user-name")); // By ... : neye göre bulacağını belirliyoruz.
        usernameInput.sendKeys("standard_user"); // yazı yazma işlemi.
        Thread.sleep(1000); // beklemek istenen milisaniye.

        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(1000);

        WebElement loginBtn = webDriver.findElement(By.id("login-button"));
        loginBtn.click();


        //3. Kullanıcı sisteme giriş yapamasın.

        WebElement UsernameInputTrue = webDriver.findElement(By.id("user-name"));
        UsernameInputTrue.sendKeys("standard_user"); // yazı yazma işlemi.
        Thread.sleep(1000); // beklemek istenen milisaniye.

        WebElement passwordInputFalse = webDriver.findElement(By.id("password"));
        passwordInputFalse.sendKeys("secret_sce");
        Thread.sleep(1000);


    }
}