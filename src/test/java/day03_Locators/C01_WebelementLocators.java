package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebelementLocators {
    public static void main(String[] args) {
        System.setProperty("webdriver.com.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        //Arama kutusunu locate edelim
        //Arama kutusuna iphone yazdıralım ve aratalım
        driver.findElement(By.id("twotabsearchtextbox"));
        /*
        Bir webelementin locate'ini birden fazla kullanacaksanız bir Webelement
        değişken olarak atayabilirsiniz
        Webelement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox")); şeklinde kullanabiliriz
        1) Locate işlemi bittikten sonra eğer webelemente bir metin göndereceksek sendKeys() methodu kullanırız
        2) webelemente tıklayacaksak click() methodu kullanırız
        3) webelementin üzerindeki yazıyı almak istiyorsak getText() methodu kullanırız
        4) sendKeys() methodundan sonra (yani webElemente mentin gönderdikten sonra) Keys.ENTER ile ya da
        submit() methodu ile manuel olarak enter yaptığımız gibi otomasyonda da yapabiliriz.
         */
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sayfayı kapatalım
        driver.close();






    }
}
