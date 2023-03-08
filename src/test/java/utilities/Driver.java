package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class Driver {

    private Driver(){

    }

    static WebDriver driver;


    public static WebDriver getDriver(){ //driver'i getir her yerde kullanabilmek içinde static yaptık

        if (driver==null) {

            switch (ConfigReader.getProperty("browser")){

                case "chrome" :  //browser kısmı değiştirilebilir hangisini istersek onun ayarlamasını yaparız
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver= new EdgeDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "headless-chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
              //  case "opera":
                //    WebDriverManager.operadriver().setup();
               //     driver=new OperaDriver();
              //      break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }



            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }

        return driver;
    }

    public static void closeDriver(){

        if (driver!=null) { //diver'a değer atanmamışsa
            driver.close();
            driver = null; //Kapandıktan sonraki açmaları garanti altına almak için driver'i tekrar null yaptık
        }

    }

    public static void quitDriver(){

        if (driver!=null) {//diver'a değer atanmamışsa
            driver.quit();
            driver = null;//Kapandıktan sonraki açmaları garanti altına almak için driver'i tekrar null yaptık
        }

    }

}

/*
    POM'de Driver icin TestBase class'ina extends etmek yerine
    Driver class'indan static method'lar kullanarak
    driver olusturup, ilgili ayarlarin yapilmasi
    ve en sonda driver'in kapatilmasi tercih edilmistir.
    POM'de Driver class'indaki getDriver()'in obje olusturularak kullanilmasini
    engellemek icin
    Singleton pattern kullanimi benimsenmistir
    Singleton Pattern : tekli kullanim, bir class'in farkli class'lardan
                        obje olusturarak kullanimini engellemek icin kullanilir
    Bunu saglamak icin yapmamiz gereken sey oldukca basit
    obje olusturmak icin kullanilan constructor'i private yaptiginizda
    baska class'larda Driver class'indan obje olusturulmasi mumkun OLMAZ
     */
// HER ZAMAN KULLANABİLECEGİMİZ HAZİR SABLON


    /*
    Testlerimizi çalıştırdığımızda her seferinde yeni driver oluşturduğu için her test methodu için yeni bir pencere(driver)
    açıyor. Eğer dirver'e bir değer atanmamışsa yani driver==null; ise bir kere driver'i çalıştırır diyerek bir kere if()
    içini çalıştıracak. Ve driver artık bir kere çalıştığı için ve değer atandığı için null olmayacak ve direkt return edecek
    ve diğer testlerimiz aynı pencere(driver) üzerinde çalışacak.
    Bu if kontrolü ilk çağrılan amazon için null değildir, dolayısı ile if bloğu çalışır,
    diğer sayfalar için yeni chrome sayfası açmaz, daha önce açılanı kullanır.
     */

// if şartı kullanmadan eski hali ile kaldığında ve browser kapalı olduğunda yine  kapatmak istediğinde exceptıon fırlatır.

/*
Metotları utilities'den
Web elementleri pages'den alıp
Tests'te işlem yapacağız
 */
