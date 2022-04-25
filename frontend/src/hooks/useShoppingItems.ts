import {useState} from "react";
import {ShoppingItem} from "../model/ShoppingItem";


export default function useShoppingItems(){
    const [shoppingItems , setShoppingItems ] = useState < ShoppingItem [] >([]);


return {shoppingItems}}