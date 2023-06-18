package api.models.cart;

import lombok.Data;

@Data
public class ProductInCartModel {
    private String productId, quantity;
}
