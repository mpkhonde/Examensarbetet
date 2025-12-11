package se.projektarbete.examearbete;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin(origins = "http://localhost:3000")
public class FocusSessionController {

    private final FocusSessionRepository repository;

    public FocusSessionController(FocusSessionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<FocusSession> getAllSessions() {
        return repository.findAll();
    }

    @PostMapping
    public FocusSession createSession(@RequestBody FocusSession session) {
        if (session.getParticipants() == 0) {
            session.setParticipants(1);
        }
        return repository.save(session);
    }
}
