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
        delay(6);

    }

    @Test
    public void createPublishTest() throws Exception {

        insta.whileTab();
        delay(3);
        insta.pressKeyboardEnter();
        delay(3);
        insta.pressKeyboardTab();
        delay(3);
        insta.pressKeyboardEnter();
        delay(3);
        insta.fillInputImag();
        delay(3);
        insta.pressBtnNext();
        delay(3);
        insta.pressBtnNext();
        delay(3);
        insta.fillInputLegend();
        delay(3);
        insta.pressBtnPublish();
        delay(10);

    }

}