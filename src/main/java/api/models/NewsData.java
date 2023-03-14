package api.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import helper.DataHelper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewsData {
    @JsonProperty()
    Integer id;
    @JsonUnwrapped()
    String title;
    @JsonProperty()
    String description;
    @JsonProperty()
    String date;
    @JsonProperty()
    List<String> keywords;
    @JsonProperty()
    Boolean visible;


    // Задумка понятна, но как вариант я бы предложил вынести эту чать из модели
    // потому что, конвертация даты и сбор строки уже смахивает на бизнес логику, ведь возможно потребуется другой вариант вывода,
    // а мы в модели
    // лучше иметь какой-нибудь NewsPrintAdapter снаружи, который будет собирать вывод
    @Override
    public String toString() {
        return DataHelper.convertToBeautyData(date) + "\n" + "Название: " + title + "\n" + "Новость: " + description; //todo title может быть пустым
    }
}
