package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;
import java.util.Objects;

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
    @Column(name = "instruction", nullable = true,columnDefinition = "TEXT")
    private String instruction;
    @Basic
    @Column(name = "description", nullable = true,columnDefinition = "TEXT")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private AccessoriesTypes accessoriesType;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Products product;
}
