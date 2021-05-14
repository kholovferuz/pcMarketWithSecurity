package uz.pdp.pcmarket.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String model;
    private String description;
    private Double price;
    private Integer starRate;
    @OneToOne
    private Attachment attachment;
    @ManyToOne
    private Category category;


}
