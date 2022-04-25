import React from 'react';
import './App.css';
import {ShoppingItem} from "./model/ShoppingItem";
import useShoppingItems from "./hooks/useShoppingItems";
import ShoppingItemsOverview from "./components/ShoppingItemsOverview";

function App() {
    const {shoppingItems} = useShoppingItems()

  return (
    <div className="App">
        <ShoppingItemsOverview shoppingItems={shoppingItems}/>
    </div>
  );
}

export default App;
