package api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class NewsModel {
    @JsonIgnore()
    Object name;
    @JsonIgnore()
    Object location;
    @JsonProperty()
    List<NewsData> news;
}
