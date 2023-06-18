package api.models.product;

import lombok.Data;

@Data
public class PostProductModel {
    private String title, price, category, description, image;
}
