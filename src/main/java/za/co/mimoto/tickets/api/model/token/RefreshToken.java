package za.co.mimoto.tickets.api.model.token;


import za.co.mimoto.tickets.api.model.UserDevice;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;


@Entity
@Table(name = "refresh_token")
public class RefreshToken implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refresh_token_seq")
    @SequenceGenerator(name = "refresh_token_seq", allocationSize = 1)
    private Long id;

    @Column(name = "expiryDate")
    private Instant expiryDate;

    @Column(name = "refreshCount")
    private Long refreshCount;

    @Column(name = "token")
    private String token;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_device_id", unique = true)
    private UserDevice userDevice;

    public RefreshToken() {
    }

    public RefreshToken(Long id, Instant expiryDate, Long refreshCount, String token, UserDevice userDevice) {
        this.id = id;
        this.expiryDate = expiryDate;
        this.refreshCount = refreshCount;
        this.token = token;
        this.userDevice = userDevice;
    }

    public void incrementRefreshCount() {
        refreshCount = refreshCount + 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Instant expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getRefreshCount() {
        return refreshCount;
    }

    public void setRefreshCount(Long refreshCount) {
        this.refreshCount = refreshCount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDevice getUserDevice() {
        return userDevice;
    }

    public void setUserDevice(UserDevice userDevice) {
        this.userDevice = userDevice;
    }
}
