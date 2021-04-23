package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Team;
import uz.pdp.pcmarket.projection.TeamProjection;

@RepositoryRestResource(path = "team",excerptProjection = TeamProjection.class)
public interface TeamRepository extends JpaRepository<Team, Integer> {

}
