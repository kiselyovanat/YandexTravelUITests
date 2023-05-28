package api.models.product;

import lombok.Data;

@Data
public class DeleteResponseProductModel {
    String id, title, price, category, description, image;
}
