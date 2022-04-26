import {ShoppingItem} from "../model/ShoppingItem";
import "./ShoppingItemCard.css";


type ShoppingItemCardProps = {
    shoppingItem: ShoppingItem
}

export default function ShoppingItemCard({shoppingItem}:ShoppingItemCardProps){
    return(
        <div className={"shopping-item-card"}>
            <div className={"bulletpoint"}></div>
            <h4>

                {shoppingItem.name}
            </h4>

        </div>
    )
}