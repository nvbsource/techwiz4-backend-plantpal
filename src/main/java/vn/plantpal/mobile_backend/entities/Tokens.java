package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tokens")
public class Tokens {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Basic
    @Column(name = "token", nullable = false, length = 255)
    private String token;
    @Basic
    @Column(name = "token_type", nullable = false, length = 30)
    private String tokenType;
    @Basic
    @Column(name = "expiry_time", nullable = false)
    private Date expiryTime;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    @Basic
    @Column(name = "account_id", nullable = false, length = 36)
    private String accountId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Accounts accountsByAccountId;
    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID().toString();
    }

}
