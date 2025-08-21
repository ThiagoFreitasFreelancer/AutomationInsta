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
        delay(2);
        insta.pressKeyboardEnter();
        delay(2);
        insta.pressKeyboardTab();
        delay(2);
        insta.pressKeyboardEnter();
        delay(20);
        insta.fillInputImagLocal();
        delay(5);
        insta.pressBtnNext();
        delay(5);
        insta.pressBtnNext();
        delay(5);
        insta.fillInputLegend();
        delay(5);
        insta.pressBtnPublish();
        delay(15);

    }

}