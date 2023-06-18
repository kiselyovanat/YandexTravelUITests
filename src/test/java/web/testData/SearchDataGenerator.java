package web.testData;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.text.WordUtils.capitalizeFully;

public class SearchDataGenerator {

    public static Locale ruLocale = new Locale("ru");

    public static Faker faker = new Faker(ruLocale);

    public static SearchData generateSearchParams(String departureCity, String destinationCity) {

        Date startDate = faker.date().future(10, 3, TimeUnit.DAYS);
        String startDay = (new SimpleDateFormat("d", ruLocale)).format(startDate),
                startMonth = capitalizeFully((new SimpleDateFormat("MMMM", ruLocale)).format(startDate));
        Date endDate = faker.date().future(30, 11, TimeUnit.DAYS);
        String endDay = (new SimpleDateFormat("d", ruLocale)).format(endDate),
                endMonth = capitalizeFully((new SimpleDateFormat("MMMM", ruLocale)).format(endDate));

        return new SearchData()
                .setStartDay(startDay)
                .setStartMonth(startMonth)
                .setEndDay(endDay)
                .setEndMonth(endMonth)
                .setDepartureCity(departureCity)
                .setDestinationCity(destinationCity);
    }
}
