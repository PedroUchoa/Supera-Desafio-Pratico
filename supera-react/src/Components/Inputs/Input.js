import Styles from './Input.module.css'

function Input({ type, text, name, handleOnChange,value }) {
    return (
        <div className={Styles.form_controler}>
            <label htmlFor={name}>{text}</label>
            <input type={type} name={name} id={name} onChange={handleOnChange} value={value} />
        </div>
    )
}

export default Input