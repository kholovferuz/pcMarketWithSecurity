package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.OutputProduct;
import uz.pdp.pcmarket.entity.Product;

import java.util.List;


@Projection(types = OutputProduct.class)
public interface OutputProductProjection {
    Integer getId();
    Integer getQuantity();

    List<Product> getProducts();
}
