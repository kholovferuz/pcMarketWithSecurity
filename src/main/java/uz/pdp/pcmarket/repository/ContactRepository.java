package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Contact;
import uz.pdp.pcmarket.projection.ContactProjection;

@RepositoryRestResource(path = "contact",excerptProjection = ContactProjection.class)
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
