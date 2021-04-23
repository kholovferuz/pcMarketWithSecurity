package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Characteristic;
import uz.pdp.pcmarket.projection.CharacteristicsProjection;

@RepositoryRestResource(path = "characteristics",excerptProjection = CharacteristicsProjection.class)
public interface CharacteristicsRepository extends JpaRepository<Characteristic, Integer> {

}
