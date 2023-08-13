package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "users")
public class Users {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "email", nullable = true, length = 40)
    private String email;
    @Basic
    @Column(name = "age", nullable = true)
    private Integer age;
    @Basic
    @Column(name = "full_name", nullable = true, length = 50)
    private String fullName;
    @Basic
    @Column(name = "phone", nullable = true, length = 15)
    private String phone;
    @Basic
    @Column(name = "address", nullable = true, length = 255)
    private String address;
    @Basic
    @Column(name = "gender", nullable = true)
    private Boolean gender;
    @Basic
    @Column(name = "dob", nullable = true)
    private Date dob;
    @Basic
    @Column(name = "avatar", nullable = true, length = 255)
    private String avatar;
    @Basic
    @Column(name = "is_deleted", nullable = true)
    private Boolean isDeleted;
    @Basic
    @Column(name = "is_activated", nullable = true)
    private Boolean isActivated;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Collection<Billings> billings;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Collection<Carts> carts;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Accounts account;
    @OneToMany(mappedBy = "user")
    private Collection<Favorites> favorites;
    @OneToMany(mappedBy = "user")
    private Collection<Feedback> feedbacks;

}
