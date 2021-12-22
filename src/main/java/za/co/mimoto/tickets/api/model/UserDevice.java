package za.co.mimoto.tickets.api.model;


import za.co.mimoto.tickets.api.model.token.RefreshToken;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_device")
public class UserDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_device_seq")
    @SequenceGenerator(name = "user_device_seq", allocationSize = 1)
    private Long id;

    @Column(name = "deviceId")
    private String deviceId;

    @Column(name = "deviceType")
    @Enumerated(value = EnumType.STRING)
    private DeviceType deviceType;

    @Column(name = "isRefreshActive")
    private Boolean isRefreshActive;

    @Column(name = "notificationToken")
    private String notificationToken;

    @OneToOne( mappedBy = "userDevice")
    private RefreshToken refreshToken;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    public UserDevice() {
    }

    public UserDevice(Long id, String deviceId, DeviceType deviceType, Boolean isRefreshActive, String notificationToken, RefreshToken refreshToken, User user) {
        this.id = id;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.isRefreshActive = isRefreshActive;
        this.notificationToken = notificationToken;
        this.refreshToken = refreshToken;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public Boolean getIsRefreshActive() {
        return isRefreshActive;
    }

    public void setIsRefreshActive(Boolean isRefreshActive) {
        this.isRefreshActive = isRefreshActive;
    }

    public String getNotificationToken() {
        return notificationToken;
    }

    public void setNotificationToken(String notificationToken) {
        this.notificationToken = notificationToken;
    }

    public RefreshToken getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(RefreshToken refreshToken) {
        this.refreshToken = refreshToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
