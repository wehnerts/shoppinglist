import {useEffect, useState} from "react";
import {ShoppingItem} from "../model/ShoppingItem";
import axios from "axios";
import NewShoppingItem from "../components/NewShoppingItem";


export default function useShoppingItems(){
    const [shoppingItems , setShoppingItems ] = useState < ShoppingItem [] >([]);


    useEffect(()=>{

            axios.get("/api/shoppingitem")
                .then(response => setShoppingItems(response.data))
                .catch(console.error)

    },[])

    const addShoppingItems = (newShoppingItem : ShoppingItem) => {
        axios.post("/api/shoppingitem" , newShoppingItem)
            .then(response => response.data)
            .then(addedShoppingItem => setShoppingItems([...shoppingItems, addedShoppingItem]))
    }

return {shoppingItems, addShoppingItems}}