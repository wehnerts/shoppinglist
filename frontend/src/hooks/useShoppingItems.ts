import {useEffect, useState} from "react";
import {ShoppingItem} from "../model/ShoppingItem";
import axios from "axios";


export default function useShoppingItems(){
    const [shoppingItems , setShoppingItems ] = useState < ShoppingItem [] >([]);


    useEffect(()=>{

            axios.get("/api/shoppingitem")
                .then(response => setShoppingItems(response.data))
                .catch(console.error)

    },[])


return {shoppingItems}}