package api.tests;

import api.models.product.DeleteResponseProductModel;
import api.models.product.GetProductModel;
import api.models.product.PostProductModel;
import api.models.product.PostResponseProductModel;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static api.specs.product.DeleteProductSpec.deleteProductRequestSpec;
import static api.specs.product.DeleteProductSpec.deleteProductResponseSpec;
import static api.specs.product.GetSingleProductSpec.getSingleProductRequestSpec;
import static api.specs.product.GetSingleProductSpec.getSingleProductResponseSpec;
import static api.specs.product.PostProductSpec.postProductRequestSpec;
import static api.specs.product.PostProductSpec.postProductResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FakeStoreApiProductTests {

    @Test
    @Tag("APITest")
    @Feature("FakeStoreApi - взаимодействие с продуктами")
    @DisplayName("Получение одного продукта")
    void getSingleProductTest() {
        GetProductModel response = step("Делаем запрос на получение продукта с id=5", () ->
                given(getSingleProductRequestSpec)
                        .when()
                        .get()
                        .then()
                        .spec(getSingleProductResponseSpec)
                        .extract().as(GetProductModel.class));

        step("Проверяем наименование продукта", () ->
                assertThat(response.getTitle()).contains("Station Chain Bracelet"));
        step("Проверяем категорию продукта", () ->
                assertThat(response.getCategory()).isEqualTo("jewelery"));
        step("Проверяем цену продукта", () ->
                assertThat(response.getPrice()).isEqualTo("695"));
        step("Проверяем рейтинг продукта", () ->
                assertThat(response.getRating().getRate()).isEqualTo("4.6"));

    }

    @Test
    @Tag("APITest")
    @Feature("FakeStoreApi - взаимодействие с продуктами")
    @DisplayName("Добавление продукта")
    void addProductTest() {
        Faker faker = new Faker(new Locale("en"));
        PostProductModel productBody = new PostProductModel();

        String title = faker.commerce().productName(),
                description = faker.commerce().material(),
                category = faker.commerce().department(),
                price = faker.commerce().price(),
                image = faker.internet().image();

        productBody.setTitle(title);
        productBody.setCategory(category);
        productBody.setDescription(description);
        productBody.setPrice(price);
        productBody.setImage(image);

        PostResponseProductModel response = step("Добавляем продукт", () ->
                given(postProductRequestSpec)
                        .body(productBody)
                        .when()
                        .post()
                        .then()
                        .spec(postProductResponseSpec)
                        .extract().as(PostResponseProductModel.class));

        step("Проверяем id продукта", () ->
                assertThat(response.getId()).isEqualTo("21"));
        //в документации сказано, что в ответе возвращается полный объект,
        //но по факту возвращается только id, который всегда равен 21

    }

    @Test
    @Tag("APITest")
    @Feature("FakeStoreApi - взаимодействие с продуктами")
    @DisplayName("Удаление продукта")
    void deleteProductTest() {
        DeleteResponseProductModel response = step("Удаляем продукт", () ->
                given(deleteProductRequestSpec)
                        .when()
                        .delete()
                        .then()
                        .spec(deleteProductResponseSpec)
                        .extract().as(DeleteResponseProductModel.class));

        step("Проверяем id продукта в ответе", () ->
                assertThat(response.getId()).isEqualTo("5"));
    }
}
