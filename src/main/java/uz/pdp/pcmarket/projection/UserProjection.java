package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Attachment;
import uz.pdp.pcmarket.entity.User;


@Projection(types = User.class)
public interface UserProjection {
    Integer getId();

    String getName();

    String getEmail();

    String getMessage();

    Attachment getAttachment();
}
