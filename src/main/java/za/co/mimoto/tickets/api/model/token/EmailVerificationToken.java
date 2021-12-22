package za.co.mimoto.tickets.api.model.token;


import za.co.mimoto.tickets.api.model.TokenStatus;
import za.co.mimoto.tickets.api.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;


@Entity
@Table(name = "email_verification_token")
public class EmailVerificationToken implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_token_seq")
    @SequenceGenerator(name = "email_token_seq", allocationSize = 1)
    private Long id;

    @Column(name = "expiryDate")
    private Instant expiryDate;

    @Column(name = "token")
    private String token;

    @Column(name = "tokenStatus")
    private TokenStatus tokenStatus;

    @OneToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name = "users_id")
    private User user;

    public EmailVerificationToken() {
    }

    public EmailVerificationToken(Long id, Instant expiryDate, String token, TokenStatus tokenStatus, User user) {
        this.id = id;
        this.expiryDate = expiryDate;
        this.token = token;
        this.tokenStatus = tokenStatus;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setConfirmedStatus() {
        setTokenStatus(TokenStatus.STATUS_CONFIRMED);
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Instant expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenStatus getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(TokenStatus tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
