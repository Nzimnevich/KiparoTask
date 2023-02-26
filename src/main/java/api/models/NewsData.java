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


    @Override
    public String toString() {
        return DataHelper.convertToBeautyData(date) + "\n" + "Название: " + title + "\n" + "Новость: " + description; //todo title может быть пустым
    }
}
