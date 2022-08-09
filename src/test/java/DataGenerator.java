import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    private DataGenerator() {
    }

    public static class Registration {
        private Registration() {
        }

        public static String getCityForCard() {
            String[] cities = {"Москва", "Казань", "Волгоград", "Санкт-Петербург", "Ростов-на-Дону", "Нижний Новгород"};
            Random random = new Random();
            int index = random.nextInt(cities.length);
            return cities[index];
        }

        public static InputData generate() {
            Faker faker = new Faker(new Locale("ru"));
            LocalDate futureDate1 = LocalDate.now().plusDays(4);
            LocalDate futureDate2 = LocalDate.now().plusDays(14);

            return new InputData(

                    futureDate1,
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.phoneNumber().cellPhone(),
                    futureDate2);
        }

    }

}
