package api.specs.cart;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.hamcrest.Matchers.notNullValue;

public class GetSingleCartSpec {
    public static RequestSpecification getSingleCartRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .baseUri("https://fakestoreapi.com/")
            .basePath("carts/5");

    public static ResponseSpecification getSingleCartResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("id", notNullValue())
            .expectBody("userId", notNullValue())
            .expectBody("date", notNullValue())
            .expectBody("products", notNullValue())
            .build();
}
