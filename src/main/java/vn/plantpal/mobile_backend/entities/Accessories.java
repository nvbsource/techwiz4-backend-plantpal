package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Accessories {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "instruction", nullable = true, length = -1)
    private String instruction;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    private Double price;
//    @Basic
//    @Column(name = "type_id", nullable = true, length = 36)
//    private String typeId;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Products productsById;
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private AccessoriesTypes accessoriesTypesByTypeId;


}
