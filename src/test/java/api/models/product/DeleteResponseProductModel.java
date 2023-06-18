package api.models.product;

import lombok.Data;

@Data
public class DeleteResponseProductModel {
    private String id, title, price, category, description, image;
}
