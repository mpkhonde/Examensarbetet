import { useState } from "react";

export default function CreateSessionForm({ onCreated }) {
  const [name, setName] = useState("");
  const [owner, setOwner] = useState("");
  const [duration, setDuration] = useState(25);

  const handleSubmit = (e) => {
    e.preventDefault();

    const newSession = {
      name,
      owner,
      durationMinutes: Number(duration),
      participants: 1,
    };

    fetch("http://localhost:8080/api/sessions", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newSession),
    })
      .then((res) => res.json())
      .then((saved) => {
        onCreated(saved);          // lägg till i listan i App
        setName("");
        setOwner("");
        setDuration(25);
      })
      .catch((err) => console.error("Error:", err));
  };

  return (
    <form onSubmit={handleSubmit} style={{ marginBottom: "20px" }}>
      <h2>Skapa ny session</h2>
      <input
        placeholder="Namn"
        value={name}
        onChange={(e) => setName(e.target.value)}
      /><br/>
      <input
        placeholder="Ägare"
        value={owner}
        onChange={(e) => setOwner(e.target.value)}
      /><br/>
      <input
        type="number"
        value={duration}
        onChange={(e) => setDuration(e.target.value)}
      /><br/>
      <button type="submit">Skapa</button>
    </form>
  );
}
