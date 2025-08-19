package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

public class Browser {

    public static WebDriver driver;

        /*
        * Listas de sistemas ( Modificar parametro links[x] )
        * 0 - Instagram
        * Lista de navagadores ( modificar a variável nevigador = x )
        * 1 - Firefox
        * 2 - Edge
        * 3 - Chrome
        */

    public static WebDriver getCurrentDriver() {

        String[] links = {

            "https://www.instagram.com/",

        };
        int navigator = 1;
        String directory = "C:\\Users\\thiag\\Dev\\file\\Web-Driver";

        if ( driver == null ) {
        
            switch ( navigator ) {

                case 1:

                    System.setProperty( "webdriver.chrome.driver", directory + "\\chromedriver.exe" );
                    ChromeOptions optionsChrome = new ChromeOptions();
                    optionsChrome.addArguments( "start-maximized" );
                    optionsChrome.addArguments("--remote-allow-origins=*");
                    optionsChrome.addArguments( "--headless" );
                    driver = new ChromeDriver( optionsChrome );
                    break;

            }
           
            driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ) );
            
        }

        driver.get(links[0]);
        return driver;

    }

    public static void close() {

        getCurrentDriver().quit();
        driver = null;

    }

}
