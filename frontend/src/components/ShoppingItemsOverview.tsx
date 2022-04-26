import {ShoppingItem} from "../model/ShoppingItem";
import ShoppingItemCard from "./ShoppingItemCard";
import NewShoppingItem from "./NewShoppingItem";

type ShoppingItemsOverviewProps = {
    shoppingItems: ShoppingItem []
    addShoppingItems : (newShoppingItem : Omit<ShoppingItem, "id">) => void
}

export default function ShoppingItemsOverview({shoppingItems, addShoppingItems} : ShoppingItemsOverviewProps){
    return(
        <div>
            {shoppingItems.map(item => <ShoppingItemCard key={item.id} shoppingItem={item}/>)}
            <NewShoppingItem addShoppingItems={addShoppingItems} />
        </div>
    )
}
