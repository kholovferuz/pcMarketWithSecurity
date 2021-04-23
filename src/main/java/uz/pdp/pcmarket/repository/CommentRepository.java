package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Comment;
import uz.pdp.pcmarket.projection.CommentProjection;

@RepositoryRestResource(path = "comment",excerptProjection = CommentProjection.class)
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
