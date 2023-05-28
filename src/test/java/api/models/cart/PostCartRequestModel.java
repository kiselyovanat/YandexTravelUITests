package api.models.cart;

import lombok.Data;

import java.util.List;

@Data
public class PostCartRequestModel {
    String userId, date;
    List<ProductInCartModel> products;
}
