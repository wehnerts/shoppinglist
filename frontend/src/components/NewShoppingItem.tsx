import {FormEvent, useState} from "react";
import {ShoppingItem} from "../model/ShoppingItem";
import "./NewShoppingItem.css";

type NewShoppingItemProps ={
    addShoppingItems : ( newShoppingItem : Omit<ShoppingItem, "id">) => void
}

export default function NewShoppingItem ({ addShoppingItems }: NewShoppingItemProps){
    const [name, setName] = useState(``)

    const onAdd = (event : FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        if (!name) {
            alert("Please enter an item!")
            return
        }
        const newShoppingItem : Omit<ShoppingItem, "id"> = {
            name : name
        }
        addShoppingItems(newShoppingItem);
        setName('')
    }

    return (
        <div className={"new-item"}>
            <form onSubmit={onAdd}>
                <input type={"text"} placeholder="Add a new item" value={name} onChange={event => setName(event.target.value)} />
                <input type={"submit"} value={"Add item"} />
            </form>
        </div>
    )
}
