package za.co.mimoto.tickets.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import za.co.mimoto.tickets.api.model.UserDevice;
import za.co.mimoto.tickets.api.model.token.RefreshToken;

import java.util.Optional;
@Repository
public interface UserDeviceRepository extends JpaRepository<UserDevice, Long>, JpaSpecificationExecutor<UserDevice> {
    @Override
    Optional<UserDevice> findById(Long id);

    Optional<UserDevice> findByRefreshToken(RefreshToken refreshToken);

    Optional<UserDevice> findByUserId(Long userId);
}