import React from 'react';
import './App.css';
import {ShoppingItem} from "./model/ShoppingItem";
import useShoppingItems from "./hooks/useShoppingItems";

function App() {
    const {shoppingItems} = useShoppingItems()
  return (
    <div className="App">
      <header className="App-header">

      </header>
    </div>
  );
}

export default App;
