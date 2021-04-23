package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Order;
import uz.pdp.pcmarket.projection.OrderProjection;

@RepositoryRestResource(path = "order",excerptProjection = OrderProjection.class)
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
