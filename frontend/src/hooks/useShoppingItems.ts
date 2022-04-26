import {useEffect, useState} from "react";
import {ShoppingItem} from "../model/ShoppingItem";
import {getAllShoppingItem, postShoppingItem} from "../api-service";

export default function useShoppingItems(){
    const [shoppingItems, setShoppingItems] = useState<ShoppingItem[]>([]);

    useEffect(()=>{
        getAllShoppingItem()
                .then(allShoppingItems => setShoppingItems(allShoppingItems))
                .catch(console.error)

    },[])

    const addShoppingItems = (newShoppingItem : Omit<ShoppingItem, "id">) => {
        postShoppingItem(newShoppingItem)
            .then(addedShoppingItem => setShoppingItems([...shoppingItems, addedShoppingItem]))
    }

return {shoppingItems, addShoppingItems}}
