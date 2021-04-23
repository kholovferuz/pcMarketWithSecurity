package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Contact;

import java.sql.Time;


@Projection(types = Contact.class)
public interface ContactProjection {
    Integer getId();

    String getTelegram();

    String getInstagram();

    String getFacebook();

    String getEmail();

    String getPhoneNumber();

    Time getWorkTime();
}
