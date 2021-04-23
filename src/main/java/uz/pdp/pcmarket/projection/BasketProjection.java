package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Basket;
import uz.pdp.pcmarket.entity.OutputProduct;
import uz.pdp.pcmarket.entity.User;


@Projection(types = Basket.class)
public interface BasketProjection {
    Integer getId();

    OutputProduct getOutputProduct();

    User getUser();

    Double getTotalPrice();
}
