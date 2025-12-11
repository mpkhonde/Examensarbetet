import { Link } from 'react-router-dom';

function Navbar() {
  return (
    <nav style={{ padding: '1rem', background: '#020617', borderBottom: '1px solid #1e293b' }}>
      <div className="container" style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <span style={{ fontWeight: 'bold' }}>FokusTillsammans</span>
        <div style={{ display: 'flex', gap: '1rem' }}>
          <Link to="/">Hem</Link>
          <Link to="/sessions">Sessioner</Link>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
