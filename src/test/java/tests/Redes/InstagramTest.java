package tests.Redes;

import org.junit.Before;
import utils.BaseTest;
import org.junit.Test;
import pageobjects.Redes.InstagramPage;

public class InstagramTest extends BaseTest {

    private final InstagramPage insta = new InstagramPage();

    @Before
    public void setupInitial() throws InterruptedException {

        insta.simplifiedLogin("INSTAGRAM_USER", "INSTAGRAM_PASSWORD");
        delay(3);

    }

    @Test
    public void createPublishTest() throws Exception {

        insta.whileTab();
        delay(3);
        insta.pressKeyboardEnter();
        delay(1);
        insta.pressKeyboardTab();
        delay(1);
        insta.pressKeyboardEnter();
        delay(1);
        insta.fillInputImag();
        delay(1);
        insta.pressBtnNext();
        delay(1);
        insta.pressBtnNext();
        delay(1);
        insta.fillInputLegend();
        delay(1);
        insta.pressBtnPublish();
        delay(10);

    }

}