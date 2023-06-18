package api.models.cart;

import lombok.Data;

import java.util.List;

@Data
public class PostCartRequestModel {
    private String userId, date;
    private List<ProductInCartModel> products;
}
