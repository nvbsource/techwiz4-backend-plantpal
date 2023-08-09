package vn.plantpal.mobile_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Basic
    @Column(name = "fullname", length = 30)
    private String fullName;
    @Basic
    @Column(name = "phone", length = 15)
    private String phone;
    @Basic
    @Column(name = "gender", length = 10)
    private String gender;
    @Basic
    @Column(name = "avatar")
    private String avatar;
    @Basic
    @Column(name = "dob")
    private Date dob;
    @Basic
    @Column(name = "address", length = 45)
    private String address;
    @Basic
    @Column(name = "account_id", length = 36)
    private String accountId;
    @Basic
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "account_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Accounts accountByAccountId;
    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID().toString();
    }
}
