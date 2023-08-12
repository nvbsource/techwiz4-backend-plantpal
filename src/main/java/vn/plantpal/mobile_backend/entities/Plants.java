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
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = true,columnDefinition = "TEXT")
    private String description;
    @Basic
    @Column(name = "instruction", nullable = true,columnDefinition = "TEXT")
    private String instruction;
    @Basic
    @Column(name = "care_level", nullable = true, length = 255)
    private String careLevel;
    @Basic
    @Column(name = "toxicity", nullable = true)
    private Boolean toxicity;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Products product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "species_id", referencedColumnName = "id")
    private Species specie;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "light_require_id", referencedColumnName = "id")
    private LightRequires lightRequire;

    public Plants(String id, String name, String description, String careLevel, Boolean toxicity, Species specie, LightRequires lightRequire) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.careLevel = careLevel;
        this.toxicity = toxicity;
        this.specie = specie;
        this.lightRequire = lightRequire;
    }
}
