package api.models.cart;

import lombok.Data;

import java.util.List;

@Data
public class CartModel {
    String id, userId, date;
    List<ProductInCartModel> products;

}
