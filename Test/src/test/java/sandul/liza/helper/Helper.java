package sandul.liza.helper;

import org.openqa.selenium.JavascriptExecutor;
import sandul.liza.driver.WebDriverSingleton;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Helper {

    public static void waitForTime(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeBrowser() throws IOException {
        WebDriverSingleton.getInstance().close();
        WebDriverSingleton.destroyInstance();
    }

}
