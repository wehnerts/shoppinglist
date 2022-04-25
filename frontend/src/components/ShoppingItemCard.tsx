import {ShoppingItem} from "../model/ShoppingItem";

type ShoppingItemCardProps = {
    shoppingItem: ShoppingItem
}

export default function ShoppingItemCard({shoppingItem}:ShoppingItemCardProps){
    return(
        <div>
            <h4>{shoppingItem.name}</h4>
        </div>
    )
}