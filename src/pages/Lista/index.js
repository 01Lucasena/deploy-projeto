// src\pages\Lista\index.js

import ListaDeUsuarios from '../../components/ListaDeUsuarios'
import { useNavigate } from 'react-router-dom'
import './styles.css'

function PaginaListaUsuarios() {
    const navigate = useNavigate()
    
return (
        <div className='pagina-lista-usuarios'>
            <div className='lista-container'>
                <h2>Lista de usuários</h2>
                <ListaDeUsuarios />
                <button onClick={() => navigate('/')} className='link-voltar'>
                    Voltar ao início
                </button>
            </div>
        </div>
    )
}

export default PaginaListaUsuarios