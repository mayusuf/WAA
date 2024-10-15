import './index.css';
import Todo from "../types/Todo";

type PropsType = {
    todos: Todo[],
    onUpdateTodo: (newTodo: Todo) => void;
    onDeleteTodo: (id: number | string) => void;
}

export default function Footer({todos, onUpdateTodo, onDeleteTodo}:PropsType) {
    return (
        <div className="todo-footer">
            <label>
                <input type="checkbox"/>
            </label>
            <span>
          <span>Finished 0</span> / {todos.length}
        </span>
            <button className="btn btn-danger">Delete Finished Tasks</button>
        </div>
    );
}