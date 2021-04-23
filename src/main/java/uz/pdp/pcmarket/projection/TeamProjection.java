package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.*;


@Projection(types = Team.class)
public interface TeamProjection {
    Integer getId();

    String getName();

    String getPosition();

    Attachment getAttachment();
}
