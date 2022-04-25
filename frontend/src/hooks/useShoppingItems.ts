import {useEffect, useState} from "react";
import {ShoppingItem} from "../model/ShoppingItem";


export default function useShoppingItems(){
    const [shoppingItems , setShoppingItems ] = useState < ShoppingItem [] >([]);


    useEffect(()=>{
        setShoppingItems(
            [
                {id: "1", name: "Nudeln"},
                {id: "2", name: "Pesto"},
                {id: "3", name: "Parmesan"},
                {id: "4", name: "Salat"}
            ]
        )
    },[])


return {shoppingItems}}