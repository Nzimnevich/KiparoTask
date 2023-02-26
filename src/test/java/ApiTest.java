import api.api.UploadNewsApiHelper;
import api.models.NewsData;
import api.models.NewsModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ApiTest {

    @Test
    public void checkJsonApi() {
        UploadNewsApiHelper.getNewsFromJsonFile();
    }

    @Test
    public void checkXMLApi() {
        UploadNewsApiHelper.getNewsFromXMLFile();
    }


    @Test
    public void transformToCollection() {
        NewsModel newsModel = UploadNewsApiHelper.getNewsFromJsonFile();
        List<NewsData> newsData = newsModel.getNews();
        String keyworld = "apple";
        List<NewsData> newsForKeywords = new ArrayList<>();
        for (int i = 0; i < newsData.size(); i++) {
            List<String> str = newsData.get(i).getKeywords();
            if (!str.isEmpty()) {
                for (int j = 0; j < str.size(); j++) {
                    if (str.get(j).equals(keyworld)) {
                        newsForKeywords.add(newsData.get(i));
                    }
                }
            }
        }
        if (!newsForKeywords.isEmpty()) {
            newsForKeywords.forEach(System.out::println);
        } else {
            System.out.println("Извините, но мы не нашли новости по этому ключевому слову");
        }
    }
}
