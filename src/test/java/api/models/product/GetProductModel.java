package api.models.product;

import lombok.Data;

@Data
public class GetProductModel {
    String id, title, price, category, description, image;
    ProductRatingModel rating;
}
