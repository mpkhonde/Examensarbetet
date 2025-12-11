package se.projektarbete.examearbete;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "focus_sessions")
public class FocusSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String owner;
    private int durationMinutes;
    private int participants;

    // Obligatorisk tom konstruktor för JPA
    public FocusSession() {
    }

    public FocusSession(String name, String owner, int durationMinutes, int participants) {
        this.name = name;
        this.owner = owner;
        this.durationMinutes = durationMinutes;
        this.participants = participants;
    }

    // Getters & setters (Lombok kan göra detta åt dig, men kör manuellt nu)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }
}
