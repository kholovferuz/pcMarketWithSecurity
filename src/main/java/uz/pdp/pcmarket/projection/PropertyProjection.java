package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.*;


@Projection(types = Property.class)
public interface PropertyProjection {
    Integer getId();

    String getName();

    Characteristic getCharacteristic();
}
