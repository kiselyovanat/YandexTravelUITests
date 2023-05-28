package api.specs.product;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.hamcrest.Matchers.notNullValue;

public class GetSingleProductSpec {

    public static RequestSpecification getSingleProductRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .baseUri("https://fakestoreapi.com/")
            .basePath("products/5");

    public static ResponseSpecification getSingleProductResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("id", notNullValue())
            .expectBody("title", notNullValue())
            .expectBody("price", notNullValue())
            .expectBody("category", notNullValue())
            .expectBody("description", notNullValue())
            .expectBody("image", notNullValue())
            .build();
}
