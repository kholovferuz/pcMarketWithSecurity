package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Comment;
import uz.pdp.pcmarket.entity.OutputProduct;
import uz.pdp.pcmarket.entity.User;


@Projection(types = Comment.class)
public interface CommentProjection {
    Integer getId();

    OutputProduct getOutputProduct();

    String getText();

    User getUser();
}
