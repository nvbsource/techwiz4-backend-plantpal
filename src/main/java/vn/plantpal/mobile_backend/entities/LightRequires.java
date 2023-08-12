package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "light_requires", schema = "TechwizDB")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LightRequires {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "strength", nullable = false, length = 255)
    private String strength;
    @Basic
    @Column(name = "orders", nullable = false, unique = true)
    private Integer orders;
    @OneToMany(mappedBy = "lightRequire", fetch = FetchType.LAZY)
    private Collection<Plants> plants;

}
