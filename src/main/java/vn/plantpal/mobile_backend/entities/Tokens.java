package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tokens {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "token", nullable = true, length = 255)
    private String token;
    @Basic
    @Column(name = "token_type", nullable = true, length = 30)
    private String tokenType;
    @Basic
    @Column(name = "expiry_time", nullable = true)
    private Instant expiryTime;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Instant createdAt;
//    @Basic
//    @Column(name = "account_id", nullable = true, length = 36)
//    private String accountId;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Accounts accountsByAccountId;


}
