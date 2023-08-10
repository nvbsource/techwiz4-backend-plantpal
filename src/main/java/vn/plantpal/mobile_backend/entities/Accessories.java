package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Accessories {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "instruction", nullable = true,length = 500)
    private String instruction;
    @Basic
    @Column(name = "description", nullable = true,length = 500)
    private String description;
    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    private Double price;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Products product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private AccessoriesTypes accessoriesType;


}
