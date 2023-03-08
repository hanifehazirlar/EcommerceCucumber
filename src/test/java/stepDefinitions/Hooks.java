/*
package stepDefinitions;


import API.base_url.MedunnaBaseUrlnq;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    public static RequestSpecification spec;
    @Before(value = "@ApiRegistrant")
    public void setup(){
        spec = new RequestSpecBuilder().setBaseUri("https://www.medunna.com/api/").build();
    }

    @After(value = "@Team17UI")
    public void tearDown(Scenario scenario) {

        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        if (!scenario.isFailed()) Driver.quitDriver();
    }

    @Before(order=4, value="@team17API")
    public void beforeApi() {

        MedunnaBaseUrlnq.setup();

    }
}*/

/*
    Cucumber'da  step definitions package'i icerisinde
    @before, @after gibi bir notasyon varsa
    extends testBase dememize gerek kalmadan
    her scenario'dan once ve/veya sonra bu method'lar calisacaktir
    Bu da bizim isteyecegimiz bir durum degildir
    Cucumber'da @before, @after kullanma ihtiyacimiz olursa
    bunu stepdefinitions package'i altinda olusturacagimiz
    hooks class'ina koyariz
    biz her scenario'dan sonra test sonucunu kontrol edip
    failed olan scenario'lar icin
    screenshoot almasi amaciyla
    @After method'u kullanacagiz
*/

 /*
    Hooks :
    -> Her scenario'lardan once veya sonra calisan kod bloklarina sahip class'dir.
    -> Cucumber'da stepDefinitions package icerisinde @before ve @after gibi notasyonlar var ise extend
       yapmadan her scenario'dan once veya sonra bu method'lar calisir. Bu da istenilen durum degildir.
       Bu notasyonlar'a ihtiyac olmasi durumunda hooks class'i kullanilir.
    -> Cucumber hooks; kod calisma akisini daha iyi yonetmeyi kolaylastirir ve kod fazlaligini azaltir.
    -> @After notasyonu kullanilarak her senaryodan sonra test sonuclari kontrol edilip "FAİLED" olan durumlarda
       "screenshot" alinarak raporlama amaciyla kullanilir.
    */

