package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Supplier;


@Projection(types = Supplier.class)
public interface SupplierProjection {
    Integer getId();

    String getName();

    String getEmail();

    String getMessage();
}
