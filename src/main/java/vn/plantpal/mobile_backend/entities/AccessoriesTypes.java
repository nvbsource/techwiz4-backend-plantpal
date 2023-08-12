package vn.plantpal.mobile_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "accessories_types", schema = "TechwizDB", catalog = "")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccessoriesTypes {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "father_type_id", referencedColumnName = "id")
    @JsonIgnore
    private AccessoriesTypes fatherAccessoriesTypes;

    @OneToMany(mappedBy = "fatherAccessoriesTypes", fetch = FetchType.LAZY)
    private Collection<AccessoriesTypes> accessoriesTypesChild;

    @OneToMany(mappedBy = "accessoriesType", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Accessories> accessories;
}
