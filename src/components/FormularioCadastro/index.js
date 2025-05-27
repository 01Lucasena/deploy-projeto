// src\components\FormularioCadastro\index.js

import { useState } from "react";
import './styles.css'
import { useNavigate } from "react-router-dom";
import useMensagem from '../../hooks/useMensagem'
import MensagemFeedback from '../MensagemFeedback'
import logo from '../../assets/images/logo.png'
import axios from 'axios'

function FormularioCadastro() {
    const [nome, setNome] = useState('')
    const [sexo, setSexo] = useState('')
    const [idade, setIdade] = useState('')
    const [altura, setAltura] = useState('')
    const [peso, setPeso] = useState('')
    const [posicao, setPosicao] = useState('')
    const [numeroCamisa, setNumeroCamisa] = useState('')
    const navigate = useNavigate()
    const { exibirMensagem , mensagem, tipoMensagem, visivel, fecharMensagem } = useMensagem()

    const cadastrarJogador = async () => {
        try {
            const response = await axios.post('http://localhost:8080/jogadores', {nome, sexo, idade, altura, peso, posicao, numeroCamisa})
            exibirMensagem(response.data.mensagem || 'Usuário cadastrado com sucesso!', 'sucesso')
            setNome('')
            setSexo('')
            setIdade('')
            setAltura('')
            setPeso('')
            setPosicao('')
            setNumeroCamisa('')
            navigate('/jogadores')
        } catch (error) {
            let erroMsg = 'Erro ao conectar ao servidor.'
            if (error.response && error.response.data) {
                erroMsg = error.response.data.mensagem
                if (error.response.data.erros) {
                    erroMsg += ' ' + Object.values(error.response.data.erros).join(', ')
                }
            }
            exibirMensagem(erroMsg, 'erro')
        }
    }

    return (
        
        
        <div className="formulario-container">
            
            <form onSubmit={(e) => {e.preventDefault(); cadastrarJogador()}}>
                <img src={logo} alt="Logo da empresa"  />
                <h1>Cadastro de Jogadores</h1>
                <p>Preencha os dados abaixo para cadastrar um novo jogador.</p>
                <input 
                    type="text"
                    id="nome"
                    placeholder="Nome"
                    value={nome}
                    onChange={(e) => setNome(e.target.value)}
                    required
                />
                <select name="sexo" value={sexo} onChange={(e) => setSexo(e.target.value)} required>
                    <option value="">Selecione o sexo</option>
                    <option value="MASCULINO">Masculino</option>
                    <option value="FEMININO">Feminino</option>
                </select>

                <input 
                    type="number"
                    id="idade"
                    placeholder="Idade"
                    value={idade}
                    min={7}
                    max={120}
                    step={1}
                    onKeyDown={(e) => {
                        if (e.key === 'e' || e.key === '-' || e.key === '+') {
                            e.preventDefault()
                        }
                    }}
                    onChange={(e) => setIdade(e.target.value)}
                    required
                />
                <input
                    type="number"
                    id="altura"
                    placeholder="Altura"
                    value={altura}
                    onChange={(e) => setAltura(parseFloat(e.target.value))}
                    step="0.01"
                    min="1.50"
                    max="2.80"
                    required
                />
                <input
                    type="number"
                    id="peso"
                    placeholder="Peso (em kg)"
                    value={peso}
                    onChange={(e) => setPeso(parseFloat(e.target.value))}
                    step="0.01"
                    min="40"
                    max="300"
                    required
                />
                <select name="posicao" value={posicao} onChange={(e) => setPosicao(e.target.value)} required>
                    <option value="">Selecione a posição</option>
                    <option value="GOLEIRO">Goleiro</option>
                    <option value="LATERAL">Lateral</option>
                    <option value="ZAGUEIRO">Zagueiro</option>
                    <option value="MEIA">Meio-campo</option>
                    <option value="ATACANTE">Atacante</option>
                </select>
                <input
                    type="number"
                    id="numeroCamisa"
                    placeholder="Número da camisa"
                    value={numeroCamisa}
                    onChange={(e) => setNumeroCamisa(e.target.value)}
                    required
                />
                <button type="submit">Cadastrar</button>
                <button onClick={() => navigate('/jogadores')} className="link-jogadores">
                    Ver usuários cadastrados
                </button>
            </form>
            <MensagemFeedback
                mensagem={mensagem}
                tipo={tipoMensagem}
                visivel={visivel}
                onclose={fecharMensagem}
            />
        </div>
    )
}

export default FormularioCadastro