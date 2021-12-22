package za.co.mimoto.tickets.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import za.co.mimoto.tickets.api.model.token.EmailVerificationToken;

import java.util.Optional;
@Repository
public interface EmailVerificationTokenRepository extends JpaRepository<EmailVerificationToken, Long>, JpaSpecificationExecutor<EmailVerificationToken> {
    Optional<EmailVerificationToken> findByToken(String token);
}