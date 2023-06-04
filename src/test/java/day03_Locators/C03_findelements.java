package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.List;

public class C03_findelements {
    public static void main(String[] args) {
        System.setProperty("webdriver.com.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Sayfadaki linklerin sayısını ve linkleri yazdıralım
        /*
        findelement ile bir webelemente ulaşabilirken, birden fazla webelement için findelement() methodu kullanırız.,
        Bu webelementlerin sayısına ulaşmak için ya da bu webelementlerin yazısını konsola yazdırabilmek için
        List<Webelement> LinklerListesi = driver.findElements(By.locator("locator değeri")) olarak kullanırız.
        Oluşturmuş olduğumuz list'i loop ile konsola yazdırabiliriz
         */
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin Sayısı = " + linklerListesi.size());
        /*
        for (WebElement w:linklerListesi ) {
            if (!w.getText().isEmpty()) {
                System.out.println(w.getText());
            }
        }
        */
        //Lambda ile yazdıralım
        linklerListesi.forEach(link -> {if (!link.getText().isEmpty()){
                                        System.out.println(link.getText());}});

        //Shop deals in Electronics webElementinin yazısını yazdıralım
        System.out.println("**************************************");
        System.out.println(driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText());
        WebElement webElementYazisi = driver.findElement(By.id("nav-link-accountListe-nav-line-1"));
        System.out.println(webElementYazisi.getText());
        //webelementin üzerindeki yazıyı olmak istiyorsak getText() methodunu kullanırız

        driver.close();


    }
}
