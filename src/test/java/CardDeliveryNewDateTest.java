import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.format.DateTimeFormatter;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryNewDateTest {
    private InputData data = DataGenerator.Registration.generate();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @BeforeEach
    void openURL() {
        open("http://localhost:9999");
    }

    @Test
    void shouldSubmitRequest() {

        SelenideElement form = $(".form");
        $("[placeholder='Город']").setValue(DataGenerator.Registration.getCityForCard());
        form.$("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        form.$("[data-test-id=date] input").setValue(formatter.format(data.getDate1()));
        form.$("[data-test-id=name] input").setValue(
                data.getName1() + " " + data.getName2());
        form.$("[data-test-id=phone] input").setValue("+7" + data.getPhone());
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        form.$("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        form.$("[data-test-id=date] input").setValue(formatter.format(data.getDate2()));
        form.$(".button").click();
        $$(".button").find(exactText("Перепланировать")).click();
        $(".notification_status_ok").shouldBe(exist);
    }
}

