import { useState } from "react";
import Input from "../Inputs/Input";
import Styles from './App.module.css'

function App() {

    const [value, setValue] = useState([]);
    const [inputs, setInputs] = useState({
        dataInicio: "",
        dataFim: "",
        operador: "",
    });


    const handleChange = (e) => {
        const name = e.target.name;
        const inputValue = e.target.value;
        setInputs((prev) => {
            return { ...prev, [name]: inputValue }
        })
    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        const url = setarUrl();
        await fetch(`http://localhost:8080/transferencias/${url}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': "*"
            },
            mode:"cors"
        })
            .then(function(response){
                if(!response.ok){
                    alert("Campos Invalidos")
                    setValue([])
                }else{
                    return response.json()
                        .then(data => setValue(data))
                }
            })
        setInputs({ dataInicio: "", dataFim: "", operador: "" })
    }

    function setarUrl() {
        if (inputs.operador === "" && inputs.dataInicio === "" && inputs.dataFim === "") {
            return "all"
        }
        if (inputs.operador === "") {
            return `${inputs.dataInicio}/${inputs.dataFim}`
        }
        if (inputs.dataInicio === "" && inputs.dataFim === "") {
            return inputs.operador;
        }

        if (inputs.operador !== "" && inputs.dataInicio !== "" && inputs.dataFim === ""){
            return `${inputs.dataInicio}/${inputs.dataFim}/${inputs.operador}`
        }
    }




    return (
        <div className={Styles.container}>
            <div className={Styles.div_inputs}>
                <Input text="Data de Inicio" type="date" name="dataInicio" handleOnChange={handleChange} value={inputs.dataInicio}></Input>
                <Input text="Data de Fim" type="date" name="dataFim" handleOnChange={handleChange} value={inputs.dataFim}></Input>
                <Input text="Nome do operador transacionado" type="text" name="operador" handleOnChange={handleChange} value={inputs.operador}></Input>
            </div>
            <button onClick={handleSubmit}>Pesquisar</button>
            <table>
                <thead>
                    <tr>
                        <th>Dados</th>
                        <th>Valencia</th>
                        <th>Tipo</th>
                        <th>Nome do operador transacionado</th>
                    </tr>
                </thead>
                <tbody>
                    {value.length !== 0 ? (
                        value.map((val, key) => {
                            return (
                                <tr key={key}>
                                    <td>{val.dataTransferencia}</td>
                                    <td>R${val.valor}</td>
                                    <td>{val.tipo}</td>
                                    <td>{val.nomeOperadorTransacao}</td>
                                </tr>
                            )
                        })
                    ) : (
                        <tr>
                            <td>Sem valor</td>
                            <td>Sem valor</td>
                            <td>Sem valor</td>
                            <td>Sem valor</td>
                        </tr>
                    )}
                </tbody>
            </table>

        </div>
    )


}
export default App;