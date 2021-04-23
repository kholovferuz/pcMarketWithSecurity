package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.*;


@Projection(types = Characteristic.class)
public interface CharacteristicsProjection {
    Integer getId();

    String getName();

    Product getProduct();

}
