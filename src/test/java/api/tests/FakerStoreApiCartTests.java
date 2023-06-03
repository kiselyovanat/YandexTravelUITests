package api.tests;

import api.models.cart.CartModel;
import api.models.cart.PostCartRequestModel;
import api.models.cart.PostCartResponseModel;
import api.models.cart.ProductInCartModel;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static api.specs.cart.DeleteCartSpec.deleteCartRequestSpec;
import static api.specs.cart.DeleteCartSpec.deleteCartResponseSpec;
import static api.specs.cart.GetSingleCartSpec.getSingleCartRequestSpec;
import static api.specs.cart.GetSingleCartSpec.getSingleCartResponseSpec;
import static api.specs.cart.PostCardSpec.postCartRequestSpec;
import static api.specs.cart.PostCardSpec.postCartResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FakerStoreApiCartTests {

    @Test
    @Tag("APITest")
    @Feature("FakeStoreApi - взаимодействие с корзинами")
    @DisplayName("Получение одной корзины")
    void getSingleCartTest() {
        CartModel response = step("Делаем запрос на получение корзины с id=5", () ->
                given(getSingleCartRequestSpec)
                        .when()
                        .get()
                        .then()
                        .spec(getSingleCartResponseSpec)
                        .extract().as(CartModel.class));

        step("Проверяем id корзины", () ->
                assertThat(response.getId()).isEqualTo("5"));
        step("Проверяем id юзера", () ->
                assertThat(response.getUserId()).isEqualTo("3"));
    }

    @Test
    @Tag("APITest")
    @Feature("FakeStoreApi - взаимодействие с корзинами")
    @DisplayName("Добавление корзины юзеру")
    void addCartTest() {
        Faker faker = new Faker();

        Integer userId = faker.number().numberBetween(15, 30);
        LocalDate date = LocalDate.now();

        ProductInCartModel product1 = new ProductInCartModel(),
                product2 = new ProductInCartModel();
        product1.setProductId("6");
        product1.setQuantity("2");
        product2.setProductId("4");
        product2.setQuantity("3");

        List<ProductInCartModel> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        PostCartRequestModel cartBody = new PostCartRequestModel();
        cartBody.setDate(date.toString());
        cartBody.setUserId(userId.toString());
        cartBody.setProducts(products);

        PostCartResponseModel response = step("Добавляем корзину юзеру с id = " + userId, () ->
                given(postCartRequestSpec)
                        .body(cartBody)
                        .when()
                        .post()
                        .then()
                        .spec(postCartResponseSpec)
                        .extract().as(PostCartResponseModel.class));

        step("Проверяем id корзины", () ->
                assertThat(response.getId()).isEqualTo("11"));
        //в документации сказано, что в ответе возвращается полный объект,
        //но по факту возвращается только id, который всегда равен 11
    }

    @Test
    @Tag("APITest")
    @Feature("FakeStoreApi - взаимодействие с корзинами")
    @DisplayName("Удаление корзины")
    void deleteCartTest() {
        CartModel response = step("Удаляем корзину", () ->
                given(deleteCartRequestSpec)
                        .when()
                        .delete()
                        .then()
                        .spec(deleteCartResponseSpec)
                        .extract().as(CartModel.class));

        step("Проверяем id продукта в ответе", () ->
                assertThat(response.getId()).isEqualTo("5"));
        step("Проверяем id юзера", () ->
                assertThat(response.getUserId()).isEqualTo("3"));
    }
}
