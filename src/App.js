import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import CadastroJogador from "./pages/Cadastro";
import ListaJogadores from "./pages/Lista";


function App() {
    return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/cadastro" element={<CadastroJogador />} />
        <Route path="/jogadores" element={<ListaJogadores />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
