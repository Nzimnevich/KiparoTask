import api.api.UploadNewsApiHelper;
import api.models.NewsData;
import api.models.NewsModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartApplication {

    static final Scanner sc = new Scanner(System.in);
    static String answer = null;
    static NewsModel newsModel;

    public static void main(String[] args) {
        newsModel = downloadFile(sc);
        printInformation(sc, newsModel);
    }

    public static NewsModel downloadFile(Scanner scanner) {
        NewsModel newsModel = null;
        while (true) {
            System.out.println("Нажмите 1 что-бы скачать JSON, 2 - XML");
            if (scanner.hasNext()) {
                answer = scanner.nextLine();
                if (answer.equals("1")) {
                    newsModel = downloadFileFromJson();
                    break;
                } else if (answer.equals("2")) {
                    newsModel = downloadFileFromXML();
                    break;
                } else {
                    System.out.println("Вы ввели недопустимое значение");
                }
            }
        }
        return newsModel;
    }

    public static NewsModel downloadFileFromJson() {
        return UploadNewsApiHelper.getNewsFromJsonFile();
    }

    public static NewsModel downloadFileFromXML() {
        return UploadNewsApiHelper.getNewsFromXMLFile();
    }

    public static void printInformation(Scanner scanner, NewsModel newsModel) {
        while (true) {
            System.out.println("1 - вывести все новости, 2 - поиск по keyword");
            if (scanner.hasNext()) {
                answer = scanner.nextLine();
                if (answer.equals("1")) {
                    for (int i = 0; i < newsModel.getNews().size(); i++) {
                        String news = newsModel.getNews().get(i).toString();
                        System.out.println(news);
                    }
                    break;
                } else if (answer.equals("2")) {
                    answer = scanner.nextLine();
                    printForKeyword(answer, newsModel);
                    break;
                } else {
                    System.out.println("Вы ввели недопустимое значение");
                }
            }
        }

    }

    public static void printForKeyword(String keyword, NewsModel newsModel) {
        List<NewsData> newsForKeywords = new ArrayList<>();
        List<NewsData> newsData = newsModel.getNews();
        for (int i = 0; i < newsData.size(); i++) {
            List<String> str = newsData.get(i).getKeywords();
            if (!str.isEmpty()) {
                for (int j = 0; j < str.size(); j++) {
                    if (str.get(j).equals(keyword)) {
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
