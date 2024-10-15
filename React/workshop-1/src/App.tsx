import React, {useEffect, useState} from 'react';
import './App.css';
import Todo from "./types/Todo";
import Header from "./Header";
import List from "./List";
import Footer from "./Footer";
import {v4 as uuidv4} from 'uuid';

function App() {

  const [todos, setTodos] = useState<Todo[]>([]);

  useEffect(() => {
    async function getTodos(){
      const response = await fetch('http://localhost:3000/todos');
      const data = await response.json();
      setTodos(data);
    }
    getTodos();
  }, []);

  const addNewTodo = (name: string) => {
    setTodos([{id: uuidv4(), name, done: false}, ...todos])
  }

  const updateTodo = (newTodo: Todo) => {
    // const filteredTodo = todos.filter(todo => todo.id !== newTodo.id);
    // filteredTodo.push(newTodo);
    const oldTodo = todos.find(todo => todo.id === newTodo.id);
    if (oldTodo) {
      oldTodo.done = newTodo.done;
      setTodos([...todos]);
    }
  }

  const deleteTodo = (id: number | string) => {
    const filteredTodos = todos.filter(todo => todo.id !== id);
    setTodos([...filteredTodos]);
  }

  return (
      <div className="todo-container">
        <div className="todo-wrap">
          <Header onAddNewTodo={addNewTodo}/>
          <List todos={todos} onUpdateTodo={updateTodo} onDeleteTodo={deleteTodo}/>
          <Footer todos={todos} onUpdateTodo={updateTodo} onDeleteTodo={deleteTodo}/>
        </div>
      </div>
  );
}

export default App;
