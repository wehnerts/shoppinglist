import {useState} from "react";

type NewShoppingItemProps ={
    onAdd : ( name : string) => void
}

export default function NewShoppingItem ({ onAdd }: NewShoppingItemProps){
    const [name, setName] = useState(``)
}