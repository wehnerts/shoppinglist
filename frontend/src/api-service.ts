import axios from "axios";
import {ShoppingItem} from "./model/ShoppingItem";

export const postShoppingItem: (newShoppingItem: Omit<ShoppingItem, "id">) => Promise<ShoppingItem> = (newShoppingItem) => {
    return axios.post("/api/shoppingitem" , newShoppingItem)
        .then(response => response.data)
}

export const getAllShoppingItem: () => Promise<ShoppingItem[]>  = () => {
    return axios.get("/api/shoppingitem")
        .then(response => response.data)
}
