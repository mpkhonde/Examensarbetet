import { useEffect, useState } from "react";

function SessionsList() {
  const [sessions, setSessions] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/sessions")
      .then(res => res.json())
      .then(data => setSessions(data))
      .catch(err => console.error("Error:", err));
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h2>Fokussessioner</h2>
      <ul>
        {sessions.map(s => (
          <li key={s.id}>
            <strong>{s.name}</strong> — {s.owner} ({s.durationMinutes} min)
          </li>
        ))}
      </ul>
    </div>
  );
}

export default SessionsList;
