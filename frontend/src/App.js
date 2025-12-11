import React, { useEffect, useState } from "react";
import CreateSessionForm from "./CreateSessionForm";

function App() {
  const [sessions, setSessions] = useState([]);

  // Lägg till ny session i listan när backend svarar
  const addSession = (session) => {
    setSessions((prev) => [...prev, session]);
  };

  // Hämta alla befintliga sessioner vid start
  useEffect(() => {
    fetch("http://localhost:8080/api/sessions")
      .then((res) => res.json())
      .then((data) => setSessions(data))
      .catch((err) => console.error("Error vid hämtning:", err));
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>Fokussessioner</h1>

      <CreateSessionForm onCreated={addSession} />

      <ul>
        {sessions.map((s) => (
          <li key={s.id}>
            <strong>{s.name}</strong> – {s.owner} ({s.durationMinutes} min)
            <br />
            Deltagare: {s.participants}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
