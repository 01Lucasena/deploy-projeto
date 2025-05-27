import React from 'react';
import { useNavigate } from 'react-router-dom';
import logo from '../../assets/images/logo.png';
import './styles.css';


function Home() {
  const navigate = useNavigate();

  return (
   <div className="home-container">
      <img src={logo} alt="Logo do Clube" className="logo" />
      <hr></hr>
      <div className="buttons">
        <button onClick={() => navigate('/cadastro')}>Cadastro de Jogadores</button>
        <button onClick={() => navigate('/jogadores')}>Lista de Jogadores</button>
      </div>
    </div>
  );
}

export default Home;