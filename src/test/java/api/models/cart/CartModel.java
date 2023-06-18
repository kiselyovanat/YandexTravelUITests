package api.models.cart;

import lombok.Data;

import java.util.List;

@Data
public class CartModel {
    private String id, userId, date;
    private List<ProductInCartModel> products;

}
