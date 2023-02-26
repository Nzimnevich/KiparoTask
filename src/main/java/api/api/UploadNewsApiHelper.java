package api.api;

import api.base.SpecHelper;
import api.endpoints.NewsKiparoEndpoints;
import api.models.NewsModel;
import io.restassured.common.mapper.TypeRef;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class UploadNewsApiHelper {

    public  synchronized static NewsModel getNewsFromJsonFile() {
        return given()
                .spec(SpecHelper.getRequestJsonSpec())
                .when()
                .get(NewsKiparoEndpoints.NEWS.getEndpoint())
                .then()
                .spec(SpecHelper.getResponseSpec(SC_OK))
                .extract()
                .as(NewsModel.class);
    }

    public synchronized static NewsModel getNewsFromXMLFile() {
        return given()
                .spec(SpecHelper.getRequestXMLSpec())
                .when()
                .get(NewsKiparoEndpoints.NEWS.getEndpoint())
                .then()
                .spec(SpecHelper.getResponseSpec(SC_OK))
                .extract()
                .as(NewsModel.class);
    }
}
