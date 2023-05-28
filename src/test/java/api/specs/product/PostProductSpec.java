package api.specs.product;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.hamcrest.Matchers.notNullValue;

public class PostProductSpec {
    public static RequestSpecification postProductRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .baseUri("https://fakestoreapi.com/")
            .basePath("products");

    public static ResponseSpecification postProductResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("id", notNullValue())
            .build();
}
