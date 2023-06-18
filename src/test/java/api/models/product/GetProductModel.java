package api.models.product;

import lombok.Data;

@Data
public class GetProductModel {
    private String id, title, price, category, description, image;
    private ProductRatingModel rating;
}
