package org.etiya;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class HW290424 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.saucedemo.com/v1/");


        //1. clear(): Input girişi yapıldıktan sonra girilen inputu siler.

        WebElement usernameInput = webDriver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");


        //2. Thread.sleep(): Bir sonraki işlem için bekleme süresi tanımlar.

        Thread.sleep(2000);
        usernameInput.clear();


        //3. getCurrentUrl(): Bulunulan sayfanın URL'sini döndürür.

        WebElement usernameInput2 = webDriver.findElement(By.id("user-name"));
        usernameInput2.sendKeys("standard_user");

        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginbtn = webDriver.findElement(By.id("login-button"));
        loginbtn.click();

        String acilanSayfa= webDriver.getCurrentUrl();
        System.out.println(acilanSayfa);


        //4. navigate().back(): Bulunulan sayfadan önceki sayfaya döndürür.

        webDriver.navigate().back();


        //5. navigate().refresh(): sayfayı yeniler.

        loginbtn.click();
        webDriver.navigate().refresh();


     /*   //6. actions.contextClick(birinciUrun).perform(): İstenilen üründe sağ tıklama işlemi yapar.

        WebElement birinciUrun = webDriver.findElement(By.id("item_4_title_link"));
        Actions actions = new Actions(webDriver);
        actions.contextClick(birinciUrun).perform(); */


        //7. By.xpath: Id'si mevcut olmayan elemente ulaşır.

        WebElement addToCart = webDriver.findElement(By.xpath("(//button[text()='ADD TO CART'])[1]"));
        addToCart.click();
        WebElement basket = webDriver.findElement(By.id("shopping_cart_container"));
        basket.click();
        WebElement addedToCart = webDriver.findElement(By.xpath("//button[text()='REMOVE']"));


        //8. is.Displayed(): Seçilmek istenen ürünün sepette ekli olup olmadığına göre mesaj döndürür.

        boolean isAdded = addedToCart.isDisplayed();
        System.out.println("Birinci ürünün sepete eklenme durumu: " +isAdded);

        WebElement devam = webDriver.findElement(By.cssSelector("button.btn_secondary"));


        //9. ...Location: Belirli bir elementin konumunu verir.

        Point devamLocation = devam.getLocation();
        int x = devamLocation.getX();
        int y = devamLocation.getY();
        System.out.println("Continue Shopping butonunun konumu: " +x+ "px." + " - " +y+ "px.");


        //10. BACK_SPACE: Inputbox içerisine girilen değerin son karakterini geri alır ve yeni giriş yapma imkanı sağlar.

        WebElement checkout = webDriver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]"));
        checkout.click();
        WebElement firstNameInput = webDriver.findElement(By.id("first-name"));
        firstNameInput.sendKeys("Bengğ");
        firstNameInput.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
        firstNameInput.sendKeys("ü");



    }

}