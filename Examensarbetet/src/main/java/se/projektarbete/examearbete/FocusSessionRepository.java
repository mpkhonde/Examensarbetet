package se.projektarbete.examearbete;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FocusSessionRepository extends JpaRepository<FocusSession, Long> {
    // just nu inget extra – standard CRUD räcker
}
