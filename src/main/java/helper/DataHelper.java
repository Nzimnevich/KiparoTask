package helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Лучше избегать в решениях любые формы <...>Helper
// В данном случае сам файл не хелпер, а вполне нужный DataConverter
// в то время как Helperы не имеют права на существование
public class DataHelper {
    private static final String FILE_DATE_PATTERN = "yyyy-MM-dd' 'HH:mm:ss' +'SSSS";
    private static final String BEAUTY_DATE_PATTERN = "dd MMMM yyyy";

    public static String convertToBeautyData(String data) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(FILE_DATE_PATTERN);
        LocalDateTime startTime = LocalDateTime.parse(data, df);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(BEAUTY_DATE_PATTERN);
        return startTime.format(formatter);
    }
}
