import { useState, useEffect } from "react";
import axios from "axios";
import './styles.css'

function ListaDeJogadores() {
    const [jogador, setJogadores] = useState([])

    useEffect(() => {
        const carregarJogadores = async () => {
            try {
                const response = await axios.get('http://localhost:8080/jogadores')
                setJogadores(response.data)
            } catch (error) {
                alert('Erro ao buscar jogadores: ', error)
                setJogadores([])
            }
        }
        carregarJogadores()
    }, [])

    return (
        <ul id="listaJogadores" className="lista-jogadores">
            {jogador.length === 0 ? (
                <li>Nenhum Jogador encontrado.</li>
            ) : (
                jogador.map( jogador => (
                    <li key={jogador.id}>
                        <strong>Nome: </strong> {jogador.nome}<br />
                        <strong>Sexo: </strong> {jogador.sexo}<br />
                        <strong>idade: </strong> {jogador.idade}<br />
                        <strong>altura: </strong> {jogador.altura}<br />
                        <strong>peso: </strong> {jogador.peso}<br />
                        <strong>posicao: </strong> {jogador.posicao}<br />
                        <strong>numeroCamisa: </strong> {jogador.numeroCamisa}<br />           
                    </li>
                ))
            )}
        </ul>
    )
    
}

export default ListaDeJogadores