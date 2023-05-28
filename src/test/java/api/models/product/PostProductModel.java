package api.models.product;

import lombok.Data;

@Data
public class PostProductModel {
    String title, price, category, description, image;
}
