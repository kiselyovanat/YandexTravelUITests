package api.models.cart;

import lombok.Data;

@Data
public class ProductInCartModel {
    String productId, quantity;
}
