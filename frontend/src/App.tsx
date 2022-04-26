import React from 'react';
import './App.css';
import useShoppingItems from "./hooks/useShoppingItems";
import ShoppingItemsOverview from "./components/ShoppingItemsOverview";

function App() {
    const {shoppingItems, addShoppingItems} = useShoppingItems()

  return (
    <div className="App">
        <ShoppingItemsOverview shoppingItems={shoppingItems} addShoppingItems={addShoppingItems}/>
    </div>
  );
}

export default App;
