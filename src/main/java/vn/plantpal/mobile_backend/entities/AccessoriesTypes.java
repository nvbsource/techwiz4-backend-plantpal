package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "accessories_types", schema = "TechwizDB", catalog = "")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccessoriesTypes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @OneToMany(mappedBy = "accessoriesTypesByTypeId")
    private Collection<Accessories> accessoriesById;


}
