import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataTest {
    //Число Месяц Год, месяц должен быть написан словами
    static final String data = "2014-10-25 12:35:00 +0300";
    private static final String FILE_DATE_PATTERN = "yyyy-MM-dd' 'HH:mm:ss' +'SSSS";
    private static final String BEAUTY_DATE_PATTERN = "dd MMMM yyyy";

    @Test
    public void transformToBeautyData() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(FILE_DATE_PATTERN);
        LocalDateTime startTime = LocalDateTime.parse(data, df);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(BEAUTY_DATE_PATTERN );
        String beautyData= startTime.format(formatter);
        System.out.println(beautyData);
    }
}
