package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Plants {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    private Double price;
//    @Basic
//    @Column(name = "species_id", nullable = true, length = 36)
//    private String speciesId;
    @Basic
    @Column(name = "care_level", nullable = true, length = 255)
    private String careLevel;
    @Basic
    @Column(name = "toxicity", nullable = true)
    private Boolean toxicity;
    @Basic
    @Column(name = "planted", nullable = true)
    private Date planted;
    @Basic
    @Column(name = "height", nullable = true)
    private Integer height;
    @Basic
    @Column(name = "width", nullable = true)
    private Integer width;
//    @Basic
//    @Column(name = "light_require_id", nullable = true, length = 36)
//    private String lightRequireId;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Products productsById;
    @ManyToOne
    @JoinColumn(name = "species_id", referencedColumnName = "id")
    private Species speciesBySpeciesId;
    @ManyToOne
    @JoinColumn(name = "light_require_id", referencedColumnName = "id")
    private LightRequires lightRequiresByLightRequireId;


}
