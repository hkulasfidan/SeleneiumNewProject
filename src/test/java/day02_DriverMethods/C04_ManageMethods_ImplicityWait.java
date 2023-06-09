package day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ManageMethods_ImplicityWait {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*
        implicitlyWait(Duration.ofSeconds(20)); sayfadaki weebelementleri görünür olana kadar
        maximum 20 saniye bekler. Eğer webelementler 2 saniyede oluşursa 2 saniye bekler ve alt satıra geçer
        Fakat belirttiğimiz max süre boyunca internetten ya da sayfana kaynaklı olarak webelementler oluşmazsa testiniz fail verir.
        Thread.sleep() java kodlarını bizim belirttiiğimiz süre kadar bekler. 30 saniye beklemesini belirtirsem 30 saniye
        bekler ve alt satıra geçer
         */
        //techproed sayfasına gidelim
        String amazonUrl = "https://amazon.com";
        String techproUrl = "https://techproeducation.com";
        driver.get(techproUrl);

        //amazona gidelim
        driver.get(amazonUrl);

        //techpro sayfasına geri dönelim
        driver.navigate().back();

        //sayfa başlığının techpro içerdiğini test edelim
        String actualTitle = driver.getTitle();
        String arananKelime = "Techpro";
        if(actualTitle.contains(arananKelime)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED : "+ actualTitle);
        //tekrar amazon sayfasına gidelim
        driver.navigate().forward();
        //sayfa başlığının amazon içerdiğini test edelim
        if(driver.getTitle().contains("Amazon")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");
        //sayfayı kapatın
        driver.close();


    }
}
